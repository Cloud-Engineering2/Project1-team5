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


@AllArgsConstructor
@ToString
@Getter
@Setter
public class CommentDto {

    private Integer commentId;
    private String commentContent;
    private User user;
    
    private Post post;
    // 정적팩토리 without ID
    public static CommentDto of(String commentContent, User user, Post post) {
        return new CommentDto(null, commentContent, user, post);
    }

    // 정적팩토리 with ID
    public static CommentDto of(Integer commentId, String commentContent, User user, Post post) {
        return new CommentDto(commentId, commentContent, user, post);
    }

    // entity -> CommentDto
    public static CommentDto from(Comment comment) {
        return new CommentDto(
                comment.getCommentId(),
                comment.getCommentContent(),
                comment.getUser(),
                comment.getPost()
        );
    }

    // CommentDto -> Comment entity
    public Comment toEntity() {
        return Comment.of(
                this.commentId,
                this.commentContent,
                this.user,
                this.post
        );
    }
    
    
    
}
