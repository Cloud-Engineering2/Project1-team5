package com.team5.fandom.entity;

import com.team5.fandom.entity.value.Tag;
import jakarta.persistence.*;
import lombok.*;


@Getter
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Integer postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fandom_id")
    private Fandom fandom;

    @Enumerated(EnumType.STRING)
    private Tag tag;

    private String img;


    public Post(Integer postId, String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.user = user;
        this.fandom = fandom;
        this.tag = tag;
        this.img = img;
    }

    public static Post of(
                          Integer postId,
                          String postTitle,
                          String postContent,
                          User user,
                          Fandom fandom,
                          Tag tag,
                          String img) {

        return new Post(postId, postTitle, postContent, user, fandom, tag, img);
    }


}
