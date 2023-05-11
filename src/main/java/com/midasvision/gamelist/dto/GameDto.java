package com.midasvision.gamelist.dto;

import com.midasvision.gamelist.entities.Game;
import lombok.Data;
import lombok.Getter;

@Getter
public class GameDto {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDto(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear();
        this.imgUrl = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
    }
}
