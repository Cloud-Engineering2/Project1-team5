package com.team5.fandom.dto;

import java.time.LocalDateTime;

import com.team5.fandom.entity.Artist;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class ArtistDto {
    private Integer artistId;
    private String artistName;
    private LocalDateTime debutDate;

    // 빌더를 활용한 정적 팩토리 메서드 (without ID)
    public static ArtistDto of(String artistName, LocalDateTime debutDate) {
        return ArtistDto.builder()
                .artistName(artistName)
                .debutDate(debutDate)
                .build();
    }

    // 빌더를 활용한 정적 팩토리 메서드 (with ID)
    public static ArtistDto of(Integer artistId, String artistName, LocalDateTime debutDate) {
        return ArtistDto.builder()
                .artistId(artistId)
                .artistName(artistName)
                .debutDate(debutDate)
                .build();
    }

    // Entity -> Dto 변환 메서드
    public static ArtistDto from(Artist artist) {
        return ArtistDto.builder()
                .artistId(artist.getArtistId())
                .artistName(artist.getArtistName())
                .debutDate(artist.getDebutDate())
                .build();
    }

    // Dto -> Entity 변환 메서드
    public Artist toEntity() {
        return Artist.of(
                this.artistId,
                this.artistName,
                this.debutDate
        );
    }
}
