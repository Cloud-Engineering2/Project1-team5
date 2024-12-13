package com.team5.fandom.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.fandom.controller.rto.response.CommentResponse;
import com.team5.fandom.dto.PostDto;
import com.team5.fandom.service.CommentService;
import com.team5.fandom.service.PostService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/f")
@RequiredArgsConstructor
public class PostController {
	
	private final CommentService commentService;
	private final PostService postService;
	
    @GetMapping("/p/{postId}")
    public String getCommentsByPostId(@PathVariable Integer postId, Model model) {
    	PostDto postDto = postService.getPostByPostId(postId);
    	
    	if(postDto == null)
    		return "error/400";
    	
    	model.addAttribute("post", postDto);
        List<CommentResponse> comments = commentService.getCommentsByPostId(postId);
        
        model.addAttribute("comments", comments);
        return "posts/form";
    }
	
	
	
//	private final PostImageService postImageService;
	
	
//    @GetMapping("/images/{postid}")
//    public ResponseEntity<PostImage> getPostImageUrl(@PathVariable Integer postid) {
//    	
//    	return ResponseEntity.ok(postImageService.getPostImageByPostId(postid));
//    }
	
}
