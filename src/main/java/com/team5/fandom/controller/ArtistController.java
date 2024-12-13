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
        return "artist/artists";
    }

    @GetMapping("/{id}")
    public String getArtistById(@PathVariable Integer id, ModelMap map) {
    	map.addAttribute("artist", artistService.getArtistById(id));
        return "artist/form";
    }

}