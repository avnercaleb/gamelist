package com.midasvision.gamelist.controller;

import com.midasvision.gamelist.dto.GameDto;
import com.midasvision.gamelist.dto.GameListDto;
import com.midasvision.gamelist.dto.ReplacementDto;
import com.midasvision.gamelist.service.GameListService;
import com.midasvision.gamelist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {
    @Autowired
    private GameListService service;
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<List<GameListDto>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }
    @GetMapping("/{id}/games")
    public ResponseEntity<List<GameDto>> listById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.searchById(id));
    }

    @PostMapping("/{id}/replacement")
    public void move(@RequestBody ReplacementDto dto, @PathVariable Long id) {
        service.move(id, dto.getSourceIndex(), dto.getDestinatioIndex());
    }
}
