package com.team5.fandom.service;

import org.springframework.stereotype.Service;

import com.team5.fandom.dto.PostDto;
import com.team5.fandom.entity.Post;
import com.team5.fandom.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {
	
	 private final PostRepository postRepository;
/*
    public PostDto getPostByPostId(Integer postId) {
        Post post = postRepository.findByPostId(postId);
        if (post == null) {
            return null;
        }
        return PostDto.toPostDto(post);
    }*/
}
