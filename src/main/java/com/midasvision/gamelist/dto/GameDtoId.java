package com.midasvision.gamelist.dto;

import com.midasvision.gamelist.entities.Game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class GameDtoId {

    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDtoId(Game game) {
        BeanUtils.copyProperties(game, this);
    }
}
