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


@AllArgsConstructor
@ToString
@Getter
@Setter
public class FandomDto {
    private Integer fandomId;
    private String fandomName;
    private Level fandomLevel;
    private Integer fandomExp;
    private Artist artist;

    // 정적팩토리 without ID
    public static FandomDto of(String fandomName, Level fandomLevel, Integer fandomExp, Artist artist) {
        return new FandomDto(null, fandomName, fandomLevel, fandomExp, artist);
    }

    // 정적팩토리 with ID
    public static FandomDto of(Integer fandomId, String fandomName, Level fandomLevel, Integer fandomExp, Artist artist) {
        return new FandomDto(fandomId, fandomName, fandomLevel, fandomExp, artist);
    }

    // Fandom entity -> FandomDto
    public static FandomDto from(Fandom fandom) {
        return new FandomDto(
                fandom.getFandomId(),
                fandom.getFandomName(),
                fandom.getFandomLevel(),
                fandom.getFandomExp(),
                fandom.getArtist()
        );
    }

    // FandomDto -> Fandom entity
    public Fandom toEntity() {
        return Fandom.of(
                this.fandomId,
                this.fandomName,
                this.fandomLevel,
                this.fandomExp,
                this.artist
        );
    }
}
