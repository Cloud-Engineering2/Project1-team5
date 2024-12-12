package com.team5.fandom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.fandom.service.ArtistService;
import com.team5.fandom.service.FandomService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/f/a")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;
    private final FandomService fandomService;

    @GetMapping
    public String getAllArtists(ModelMap map) {
    	map.addAttribute("fandoms", fandomService.getFandoms());
    	map.addAttribute("artists", artistService.getAllArtists());
        return "artist/artists";
    }

    @GetMapping("/{id}")
    public String getArtistById(@PathVariable Integer id, ModelMap map) {
    	map.addAttribute("artists", artistService.getArtistById(id));
        return "artist/form";
    }
//
//    @PostMapping
//    public String createArtist(@ModelAttribute ArtistReq artistReq, ModelMap map) {
//        // ArtistReq 데이터를 이용해 아티스트 생성
//        artistService.createArtist(artistReq);
//
//        // 다시 아티스트 목록을 가져와 뷰에 전달
//        map.addAttribute("artists", artistService.getAllArtists());
//        return "artist/form"; // 목록 페이지로 리다이렉트
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateArtist(@PathVariable Integer id, @RequestBody ArtistDto artistDto) {
//        artistService.updateArtist(id, artistDto);
//        return "";
//    }
//
//    @PostMapping("/delete/{id}")
//    public String deleteArtist(@PathVariable Integer id) {
//        artistService.deleteArtist(id);
//        return "";
//    }
}