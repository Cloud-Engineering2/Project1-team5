package com.team5.fandom.controller.rto;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Integer postId;
    private String postTitle;
    private String postContent;
    private User user;
    private Fandom fandom;
    private Tag tag;
    private String img;
}
