package com.team5.fandom.service;

import com.team5.fandom.controller.rto.request.PostReqSave;
import com.team5.fandom.dto.PostDto;
import com.team5.fandom.entity.Post;
import com.team5.fandom.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public Page<PostDto> getPostList(Pageable pageable) {

        Page<PostDto> postDtos = postRepository.findAll(pageable).map(post -> PostDto.toPostDto(post));
        return postDtos;
    }

    public PostDto getPostByPostId(Integer postId) {
        Post post = postRepository.findByPostId(postId);
        if (post == null) {
            return null;
        }
        return PostDto.toPostDto(post);
    }
    
    public Integer savePost(PostReqSave postReqSave, String imagePath) {
    	return 1;
    }
}
