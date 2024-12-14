package com.team5.fandom.entity;


import com.team5.fandom.controller.rto.response.CommentResponse;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends AuditingFields{
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "comment_content")
    private String commentContent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "post_id")
    private Post post;


    private Comment(String commentContent, User user, Post post) {
        this.commentContent = commentContent;
        this.user = user;
        this.post = post;
    }


    // No ID
    public static Comment of(String commentContent, User user, Post post) {
        return new Comment(commentContent, user, post);
    }
    
    
    public CommentResponse toCommentResponse() {
        return CommentResponse.builder()
                .commentId(this.commentId)
                .commentContent(this.commentContent)
                .userId(this.user == null ? null : this.user.getUserId())
                .userName(this.user == null ? "탈퇴한 유저" : this.user.getUserName())
                .postId(this.post.getPostId())
                .createdDate(this.getCreatedDate())
                .modifiedDate(this.getModifiedDate())
                .build();
    }

}
