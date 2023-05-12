package com.midasvision.gamelist.service;

import com.midasvision.gamelist.dto.GameDto;
import com.midasvision.gamelist.dto.GameDtoId;
import com.midasvision.gamelist.entities.Game;
import com.midasvision.gamelist.projections.GameProjection;
import com.midasvision.gamelist.repository.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ReadOnlyBufferException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository repo;
    @Transactional
    public List<GameDto> getAll() {
        return repo.findAll().stream()
                .map(e -> new GameDto(e)).collect(Collectors.toList());
    }
    @Transactional
    public GameDtoId getOne(Long id) {
        Game game =  repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return new GameDtoId(game);
    }
    @Transactional
    public List<GameDto> searchById(Long listId) {
        return repo.searchByList(listId).stream()
                .map(x -> new GameDto(x)).toList();
    }
}
