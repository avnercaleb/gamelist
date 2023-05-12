package com.midasvision.gamelist.dto;

import com.midasvision.gamelist.entities.GameList;
import lombok.Getter;

@Getter
public class GameListDto {

    private Long id;
    private String name;

    public GameListDto(GameList list) {
        this.id = list.getId();
        this.name = list.getName();
    }
}
