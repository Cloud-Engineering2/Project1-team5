package com.team5.fandom.dto;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;
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
    
    
    // 빌더를 활용한 정적 팩토리 메서드 (without ID)
    public static PostDto of(String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        return PostDto.builder()
                .postTitle(postTitle)
                .postContent(postContent)
                .user(user)
                .fandom(fandom)
                .tag(tag)
                .img(img)
                .build();
    }

    // 빌더를 활용한 정적 팩토리 메서드 (with ID)
    public static PostDto of(Integer postId, String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        return PostDto.builder()
                .postId(postId)
                .postTitle(postTitle)
                .postContent(postContent)
                .user(user)
                .fandom(fandom)
                .tag(tag)
                .img(img)
                .build();
    }

    // Entity -> Dto 변환 메서드
    public static PostDto from(Post post) {
        return PostDto.builder()
                .postId(post.getPostId())
                .postTitle(post.getPostTitle())
                .postContent(post.getPostContent())
                .user(post.getUser())
                .fandom(post.getFandom())
                .tag(post.getTag())
                .img(post.getImg())
                .build();
    }

    // Dto -> Entity 변환 메서드
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
