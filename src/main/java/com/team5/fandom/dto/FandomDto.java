package com.team5.fandom.dto;

import com.team5.fandom.entity.Artist;
import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Builder
public class FandomDto {
    private Integer fandomId;
    private String fandomName;
    private Level fandomLevel;
    private Integer fandomExp;
    private Artist artist;

    // Fandom entity -> FandomDto 변환 메서드
    public static FandomDto toFandomDto(Fandom fandom) {
        return new FandomDto(
                fandom.getFandomId(),
                fandom.getFandomName(),
                fandom.getFandomLevel(),
                fandom.getFandomExp(),
                ArtistDto.toArtistDto(fandom.getArtist()).toEntity()
        );
    }

    // FandomDto -> Fandom entity 변환 메서드
    private Fandom toEntity() {
        return Fandom.of(

                fandomName,
                fandomLevel,
                fandomExp,
                artist
        );
    }
}