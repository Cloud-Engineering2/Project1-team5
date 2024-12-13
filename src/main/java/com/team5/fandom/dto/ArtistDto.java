package com.team5.fandom.dto;

import java.time.LocalDateTime;

import com.team5.fandom.entity.Artist;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@Getter
@Builder
public class ArtistDto {
    private Integer artistId;
    private String artistName;
    private LocalDateTime debutDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private ArtistDto(Integer artistId, String artistName, LocalDateTime debutDate, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.debutDate = debutDate;
    }

    // Entity -> Dto 변환 메서드
    public static ArtistDto toArtistDto(Artist artist) {
        return new ArtistDto(
                artist.getArtistId(),
                artist.getArtistName(),
                artist.getDebutDate(),
                artist.getCreatedDate(),
                artist.getModifiedDate()
        );
    }

    // Dto -> Entity 변환 메서드
    public Artist toEntity() {
        return Artist.of(
                artistName,
                debutDate
        );
    }
}