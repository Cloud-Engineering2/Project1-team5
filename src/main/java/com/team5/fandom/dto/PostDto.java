package com.team5.fandom.dto;

import java.time.LocalDateTime;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Tag;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDto {

    private Integer postId;
    private String postTitle;
    private String postContent;
    private UserDto userDto;
    private FandomDto fandomDto;
    private Tag tag;
    private String img;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private PostDto(Integer postId, String postTitle, String postContent, UserDto userDto, FandomDto fandomDto, Tag tag, String img, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.userDto = userDto;
        this.fandomDto = fandomDto;
        this.tag = tag;
        this.img = img;
    }
//    <img th:if="${post.imageUrl != null}" th:src="${post.imageUrl}" alt="Post Image" class="image">
    // Entity -> Dto 변환 메서드
    public static PostDto toPostDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getPostTitle(),
                post.getPostContent(),
                UserDto.toUserDto(post.getUser()),
                FandomDto.toFandomDto(post.getFandom()),
                post.getTag(),
                post.getImg(),
                post.getCreatedDate(),
                post.getModifiedDate()
        );
    }

    // Dto -> Entity 변환 메서드
    public Post toEntity(User user, Fandom fandom) {
        return Post.of(
                postTitle,
                postContent,
                user,
                fandom,
                tag,
                img
        );
    }
}