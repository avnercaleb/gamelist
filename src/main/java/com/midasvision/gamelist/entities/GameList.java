package com.midasvision.gamelist.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_game_list")
@Data
public class GameList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
