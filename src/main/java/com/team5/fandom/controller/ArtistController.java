package com.team5.fandom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.fandom.service.ArtistService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/f/a")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public String getAllArtists(ModelMap map) {
    	
    	map.addAttribute("artists", artistService.getAllArtists());
        return "artist/form";
    }

}