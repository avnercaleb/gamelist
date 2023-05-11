package com.midasvision.gamelist.controller;

import com.midasvision.gamelist.dto.GameDto;
import com.midasvision.gamelist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    @Autowired
    private GameService service;
    @GetMapping("/list")
    public ResponseEntity<List<GameDto>> getALl() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }
}
