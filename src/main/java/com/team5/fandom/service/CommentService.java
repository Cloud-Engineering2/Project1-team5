package com.team5.fandom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.team5.fandom.controller.rto.response.CommentResponse;
import com.team5.fandom.entity.Comment;
import com.team5.fandom.repository.CommentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CommentService {



    private final CommentRepository commentRepository;
//    private final UserRepository userRepository;
//    private final PostRepository postRepository;
    public List<CommentResponse> getCommentsByPostId(Integer postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        if (comments == null) {
            return new ArrayList<>();
        }
        return comments.stream()
                .map(Comment::toCommentResponse)
                .collect(Collectors.toList());
    }


	

//	
//	
//	public void registerPostComment(PostCommentDto postCommentDto) {
//		User user = userRepository.getReferenceById(postCommentDto.getUserDto().getUid());
//		
//		Post post = postRepository.getReferenceById(postCommentDto.getPid());
//		
//		PostComment postComment = postCommentDto.toEntity(post, user);
//		
//		postCommentRepository.save(postComment);
//		
//	}
//	
//	@Transactional
//	public void deletePostComment(Long pcid, String uid) {
//		postCommentRepository.deleteByIdAndUser_Uid(pcid, uid);
//	}
	
}

