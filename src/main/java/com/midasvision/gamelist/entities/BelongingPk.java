package com.midasvision.gamelist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Embeddable
public class BelongingPk {

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList gameList;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
