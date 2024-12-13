package com.team5.fandom.service;

import org.springframework.stereotype.Service;

import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.PostImage;
import com.team5.fandom.repository.PostImageRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostImageService {

    private final PostImageRepository postImageRepository;
    
    public PostImage getPostImageByPostId(Integer postId) {
        return postImageRepository.findByPost_PostId(postId)
                .orElseThrow(() -> new IllegalArgumentException("Image not found for postId: " + postId));
    }
    
    
    public PostImage uploadImage(String localPath, Post post) {
        PostImage postImage = PostImage.of(localPath, post);
        return postImageRepository.save(postImage);
    }
}