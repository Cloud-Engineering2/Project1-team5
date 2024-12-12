package com.team5.fandom.controller.rto;

import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentReqSave {
    private Integer commentId;
    private String commentContent;

    private User user;

    private Post post;
}
