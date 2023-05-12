package com.midasvision.gamelist.service;

import com.midasvision.gamelist.dto.GameListDto;
import com.midasvision.gamelist.entities.GameList;
import com.midasvision.gamelist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repo;

    public List<GameListDto> listAll() {
        return repo.findAll().stream()
                .map(x -> new GameListDto(x)).toList();
    }

    public GameListDto listById(Long id) {
        GameList list =  repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return new GameListDto(list);
    }
}
