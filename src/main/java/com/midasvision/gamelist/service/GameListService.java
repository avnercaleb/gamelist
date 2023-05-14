package com.midasvision.gamelist.service;

import com.midasvision.gamelist.dto.GameDto;
import com.midasvision.gamelist.dto.GameListDto;
import com.midasvision.gamelist.entities.GameList;
import com.midasvision.gamelist.projections.GameProjection;
import com.midasvision.gamelist.repository.GameListRepository;
import com.midasvision.gamelist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repo;
    @Autowired
    private GameRepository gameRepo;
    @Transactional
    public List<GameListDto> listAll() {
        return repo.findAll().stream()
                .map(x -> new GameListDto(x)).toList();
    }

    public GameListDto listById(Long id) {
        GameList list =  repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return new GameListDto(list);
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameProjection> list = gameRepo.searchByList(listId);
        GameProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            repo.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
