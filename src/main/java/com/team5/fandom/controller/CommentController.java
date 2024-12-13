package com.team5.fandom.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.team5.fandom.controller.rto.request.CommentReqSave;
import com.team5.fandom.service.CommentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping
@Controller
public class CommentController {
	
	private final CommentService commentService;
	
	@PostMapping
	public String registerNewPostComment(
			CommentReqSave commentReqSave,
			@AuthenticationPrincipal FansDetails fansDetails
	) {

		CommentService.registerPostComment(commentReqSave.toDto(fansDetails.toDto()));
		
		return "redirect:/posts/" + commentReqSave.getPostid();
	}
	
	@PostMapping("/{pcid}/delete")
	public String deletePostComment(
			@PathVariable Long pcid,
			Long pid,
			@AuthenticationPrincipal BoardDetails boradDetails
	) {
		postCommentService.deletePostComment(pcid, boradDetails.getUid());
		return "redirect:/posts/" + pid;
	}
}


