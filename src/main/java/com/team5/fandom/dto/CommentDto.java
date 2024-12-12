package com.team5.fandom.dto;

import com.team5.fandom.entity.Comment;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Builder
public class CommentDto {

    private Integer commentId;
    private String commentContent;
    private UserDto userDto;
    private PostDto postDto;

    // entity -> CommentDto 변환 메서드
    private static CommentDto toCommentDto(Comment comment) {
        return new CommentDto(
                comment.getCommentId(),
                comment.getCommentContent(),
                UserDto.toUserDto(comment.getUser()),
                PostDto.toPostDto(comment.getPost())

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