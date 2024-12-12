package com.team5.fandom.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    private Integer artistId;

    @Column(name = "artist_name", nullable = false, length = 255)
    private String artistName;

    @Column(name = "debut_date")
    private LocalDateTime debutDate;
}
