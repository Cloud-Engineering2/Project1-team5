package com.team5.fandom.dto;

import java.time.LocalDateTime;

import com.team5.fandom.entity.Artist;
import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.value.Level;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class FandomDto {
    private Integer fandomId;
    private String fandomName;
    private Level fandomLevel;
    private Integer fandomExp;
    private ArtistDto artistDto;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    // Fandom entity -> FandomDto 변환 메서드
    public static FandomDto toFandomDto(Fandom fandom) {
        return new FandomDto(
                fandom.getFandomId(),
                fandom.getFandomName(),
                fandom.getFandomLevel(),
                fandom.getFandomExp(),
                ArtistDto.toArtistDto(fandom.getArtist()),
                fandom.getCreatedDate(),
                fandom.getModifiedDate()
        );
    }

    // FandomDto -> Fandom entity 변환 메서드
    public Fandom toEntity(Artist artist) {
        return Fandom.of(

                fandomName,
                fandomLevel,
                fandomExp,
                artist
        );
    }
}