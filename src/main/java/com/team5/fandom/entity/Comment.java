package com.team5.fandom.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment {
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


    // No ID
    public static Comment of(String commentContent, User user, Post post) {
        return new Comment(null, commentContent, user, post);
    }

    // With ID
    public static Comment of(Integer commentId, String commentContent, User user, Post post) {
        return new Comment(commentId, commentContent, user, post);
    }
}
