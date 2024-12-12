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
@Builder
public class CommentDto {

    private Integer commentId;
    private String commentContent;
    private User user;
    private Post post;
    
    // 빌더를 활용한 정적 팩토리 메서드 (without ID)
    public static CommentDto of(String commentContent, User user, Post post) {
        return CommentDto.builder()
                .commentContent(commentContent)
                .user(user)
                .post(post)
                .build();
    }

    // 빌더를 활용한 정적 팩토리 메서드 (with ID)
    public static CommentDto of(Integer commentId, String commentContent, User user, Post post) {
        return CommentDto.builder()
                .commentId(commentId)
                .commentContent(commentContent)
                .user(user)
                .post(post)
                .build();
    }

    // entity -> CommentDto 변환 메서드
    public static CommentDto from(Comment comment) {
        return CommentDto.builder()
                .commentId(comment.getCommentId())
                .commentContent(comment.getCommentContent())
                .user(comment.getUser())
                .post(comment.getPost())
                .build();
    }

    // CommentDto -> Comment entity 변환 메서드
    public Comment toEntity() {
        return Comment.of(
                this.commentId,
                this.commentContent,
                this.user,
                this.post
        );
    }
    
    
    
}
