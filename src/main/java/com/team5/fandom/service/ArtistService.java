package com.team5.fandom.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.team5.fandom.dto.ArtistDto;
import com.team5.fandom.entity.Artist;
import com.team5.fandom.repository.ArtistRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArtistService {

    private final ArtistRepository artistRepository;

    public List<ArtistDto> getAllArtists() {
        return artistRepository.findAll().stream()
                .map(ArtistDto::toArtistDto)
                .collect(Collectors.toList());
    }

     public ArtistDto getArtistById(Integer id) {
         Artist artist = artistRepository.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("NOT FOUND : " + id));
         return ArtistDto.toArtistDto(artist);
     }

    // @Transactional
    // public ArtistDto createArtist(ArtistDto artistDto) {
    //     Artist artist = artistDto.toEntity();
    //     Artist savedArtist = artistRepository.save(artist);
    //     return ArtistDto.toArtistDto(savedArtist);
    // }

    // @Transactional
    // public ArtistDto updateArtist(Integer id, ArtistDto artistDto) {
    //     Artist artist = artistRepository.findById(id)
    //             .orElseThrow(() -> new IllegalArgumentException("NOT FOUND : " + id));
    //     artist = Artist.of(id, artistDto.getArtistName(), artistDto.getDebutDate());
    //     Artist updatedArtist = artistRepository.save(artist);
    //     return ArtistDto.toArtistDto(updatedArtist);
    // }
    
    // @Transactional
    // public void deleteArtist(Integer id) {
    //     artistRepository.deleteById(id);
    // }
}
