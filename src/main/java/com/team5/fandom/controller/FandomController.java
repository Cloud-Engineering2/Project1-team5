package com.team5.fandom.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.team5.fandom.dto.FandomDto;
import com.team5.fandom.service.FandomService;
import com.team5.fandom.service.PostService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/f")
public class FandomController {

	private final FandomService fandomService;
	private final PostService postService;
	
	@GetMapping("/c")
	public String getFandoms(ModelMap model){
		List<FandomDto> fandoms = fandomService.getFandoms();
		model.addAttribute("fandoms", fandoms);
		return "/fandoms/index";
	}
	
	@GetMapping("/c/{fandomId}")
	public String getFandom(
			@RequestParam(required = false) String tag,
			@PathVariable Integer fandomId) {
		return "redirect:/f/c/{fandomId}/p";
	}
	

}