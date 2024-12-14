package com.team5.fandom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.fandom.service.CommentService;

import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {


    private final CommentService commentService;


//
//    @GetMapping("/{postId}")
//    public String getCommentsByPostId(@PathVariable Integer postId, Model model) {
//        List<CommentResponse> comments = commentService.getCommentsByPostId(postId);
//        
//        model.addAttribute("comments", comments);
//        return "posts/form";
//    }
}

	
/*
 * private final CommentService commentService;
 * 
 * @PostMapping public String registerNewPostComment( CommentReqSave
 * commentReqSave,
 * 
 * @AuthenticationPrincipal FansDetails fansDetails ) {
 * 
 * CommentService.registerPostComment(commentReqSave.toDto(fansDetails.toDto()))
 * ;
 * 
 * return "redirect:/posts/" + commentReqSave.getPostid(); }
 * 
 * @PostMapping("/{pcid}/delete") public String deletePostComment(
 * 
 * @PathVariable Long pcid, Long pid,
 * 
 * @AuthenticationPrincipal BoardDetails boradDetails ) {
 * postCommentService.deletePostComment(pcid, boradDetails.getUid()); return
 * "redirect:/posts/" + pid; } }
 */


