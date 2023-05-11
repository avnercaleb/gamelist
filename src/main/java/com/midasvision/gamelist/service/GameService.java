package com.midasvision.gamelist.service;

import com.midasvision.gamelist.dto.GameDto;
import com.midasvision.gamelist.entities.Game;
import com.midasvision.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository repo;

    public List<GameDto> getAll() {
        return repo.findAll().stream()
                .map(e -> new GameDto(e)).collect(Collectors.toList());
    }

    public GameDto getOne(Long id) {
        Game game =  repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());

        return new GameDto(game);
    }
}
