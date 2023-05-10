package com.midasvision.gamelist.service;

import com.midasvision.gamelist.entities.Game;
import com.midasvision.gamelist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repo;

    public List<Game> getAll() {
        return repo.findAll();
    }

    public Game getOne(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
