package com.team5.fandom.dto;

import java.time.LocalDateTime;

import com.team5.fandom.entity.Artist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ArtistDto {
    private Integer artistId;
    private String artistName;
    private LocalDateTime debutDate;

    // 정적팩토리 without ID
    public static ArtistDto of(String artistName, LocalDateTime debutDate) {
        return new ArtistDto(null, artistName, debutDate);
    }

    // 정적팩토리 with ID
    public static ArtistDto of(Integer artistId, String artistName, LocalDateTime debutDate) {
        return new ArtistDto(artistId, artistName, debutDate);
    }

    // Entity -> Dto
    public static ArtistDto from(Artist artist) {
        return new ArtistDto(
                artist.getArtistId(),
                artist.getArtistName(),
                artist.getDebutDate()
        );
    }

    // Dto -> Entity
    public Artist toEntity() {
        return Artist.of(
                this.artistId,
                this.artistName,
                this.debutDate
        );
    }
}
