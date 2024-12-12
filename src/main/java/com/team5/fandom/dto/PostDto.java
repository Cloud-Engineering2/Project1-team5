package com.team5.fandom.dto;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class PostDto {

    private Integer postId;
    private String postTitle;
    private String postContent;
    private User user;
    private Fandom fandom;
    private Tag tag;
    private String img;
    
    
    // 정적팩토리 without ID
    public static PostDto of(String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        return new PostDto(null, postTitle, postContent, user, fandom, tag, img);
    }

    // 정적팩토리 with ID
    public static PostDto of(Integer postId, String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        return new PostDto(postId, postTitle, postContent, user, fandom, tag, img);
    }

    // entity -> Dto
    public static PostDto from(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                post.getUser(),
                post.getFandom(),
                post.getTag(),
                post.getImg()
        );
    }

    // Dto -> entity
    public Post toEntity() {
        return Post.of(
                this.postId,
                this.postTitle,
                this.postContent,
                this.user,
                this.fandom,
                this.tag,
                this.img
        );
    }
}
