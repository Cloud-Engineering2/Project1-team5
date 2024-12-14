package com.team5.fandom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PostImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Integer imageId;

    
    @Column(name = "local_path")
    private String localPath;
    
    
    @OneToOne
    @JoinColumn(name = "post_id", unique = true)
    @JsonIgnore
    private Post post;

    
    public PostImage(String localPath, Post post) {
        this.localPath = localPath;
        this.post = post;
    }

   
    public static PostImage of(String localPath, Post post) {
        return new PostImage(localPath, post);
    }
    
    
}
