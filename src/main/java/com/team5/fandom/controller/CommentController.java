package com.team5.fandom.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.fandom.controller.rto.response.CommentResponse;
import com.team5.fandom.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
//
//    @GetMapping("/{postId}")
//    public String getCommentsByPostId(@PathVariable Integer postId, Model model) {
//        List<CommentResponse> comments = commentService.getCommentsByPostId(postId);
//        
//        model.addAttribute("comments", comments);
//        return "posts/form";
//    }
}