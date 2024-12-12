package com.team5.fandom.controller.rto.request;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Tag;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostReqSave {
    private Integer postId;
    private String postTitle;
    private String postContent;
    private User user;
    private Fandom fandom;
    private Tag tag;
    private String img;
}
