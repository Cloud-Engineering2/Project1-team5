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
@Builder
public class FandomDto {
    private Integer fandomId;
    private String fandomName;
    private Level fandomLevel;
    private Integer fandomExp;
    private Artist artist;

    // 빌더를 활용한 정적 팩토리 메서드 (without ID)
    public static FandomDto of(String fandomName, Level fandomLevel, Integer fandomExp, Artist artist) {
        return FandomDto.builder()
                .fandomName(fandomName)
                .fandomLevel(fandomLevel)
                .fandomExp(fandomExp)
                .artist(artist)
                .build();
    }

    // 빌더를 활용한 정적 팩토리 메서드 (with ID)
    public static FandomDto of(Integer fandomId, String fandomName, Level fandomLevel, Integer fandomExp, Artist artist) {
        return FandomDto.builder()
                .fandomId(fandomId)
                .fandomName(fandomName)
                .fandomLevel(fandomLevel)
                .fandomExp(fandomExp)
                .artist(artist)
                .build();
    }

    // Fandom entity -> FandomDto 변환 메서드
    public static FandomDto from(Fandom fandom) {
        return FandomDto.builder()
                .fandomId(fandom.getFandomId())
                .fandomName(fandom.getFandomName())
                .fandomLevel(fandom.getFandomLevel())
                .fandomExp(fandom.getFandomExp())
                .artist(fandom.getArtist())
                .build();
    }

    // FandomDto -> Fandom entity 변환 메서드
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
