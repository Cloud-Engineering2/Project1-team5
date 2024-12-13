package com.team5.fandom.entity;

import com.team5.fandom.common.utils.TagAttributeConverter;
import com.team5.fandom.entity.value.Tag;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
public class Post extends AuditingFields {
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
    
    //  @Enumerated(EnumType.STRING)
    @Convert(converter = TagAttributeConverter.class)
    private Tag tag;

    private String img;


    private Post(String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        this.postTitle = postTitle;
        this.postContent = postContent;
        this.user = user;
        this.fandom = fandom;
        this.tag = tag;
        this.img = img;
    }


    //No Id
    public static Post of(String postTitle, String postContent, User user, Fandom fandom, Tag tag, String img) {
        return new Post(postTitle, postContent, user, fandom, tag, img);
    }

}
