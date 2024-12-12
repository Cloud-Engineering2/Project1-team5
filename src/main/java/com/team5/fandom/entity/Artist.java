package com.team5.fandom.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
    
    
    // 정적팩토리 No ID
    public static Artist of(String artistName, LocalDateTime debutDate) {
        return new Artist(null, artistName, debutDate);
    }

    // 정적팩토리 With ID
    public static Artist of(Integer artistId, String artistName, LocalDateTime debutDate) {
        return new Artist(artistId, artistName, debutDate);
    }
}
