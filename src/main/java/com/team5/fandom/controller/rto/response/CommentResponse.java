package com.team5.fandom.controller.rto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
	private Integer commentId;
	private String commentContent;
	private Integer userId;
	private String userName;
	private Integer postId;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

}
