package com.team5.fandom.dto;

import java.time.LocalDateTime;

import com.team5.fandom.controller.rto.response.CommentResponse;
import com.team5.fandom.entity.Comment;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CommentDto {

    private Integer commentId;
    private String commentContent;
    private UserDto userDto;
    private PostDto postDto;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    // entity -> CommentDto 변환 메서드
    public static CommentDto toCommentDto(Comment comment) {
        return new CommentDto(
                comment.getCommentId(),
                comment.getCommentContent(),
                UserDto.toUserDto(comment.getUser()),
                PostDto.toPostDto(comment.getPost()),
                comment.getCreatedDate(),
                comment.getModifiedDate()

        );
    }

    
    // CommentDto -> Comment entity 변환 메서드
    public Comment toEntity(User user, Post post) {
        return Comment.of(
                commentContent,
                user,
                post
        );
    }
}