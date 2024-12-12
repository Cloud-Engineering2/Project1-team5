package com.team5.fandom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "fandom")
public class Fandom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fandomId;

    @Column(name = "fandom_name", nullable = false, length = 255)
    private String fandomName;

    @Enumerated(EnumType.STRING)
    @Column(name = "fandom_level")
    private FandomLevel fandomLevel;

    @Column(name = "fandom_exp", nullable = false)
    private Integer fandomExp;

    @ManyToOne
    @JoinColumn(name = "artist_id", unique = true)
    private Artist artist;


}

enum FandomLevel {
    BRONZE, SILVER, GOLD, PLATINUM, DIAMOND
}