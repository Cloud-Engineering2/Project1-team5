package com.team5.fandom.dto;

import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class CommentDto {

    private Integer comment_id;
    private String comment_content;
    private User user;
    private Post post;
}
