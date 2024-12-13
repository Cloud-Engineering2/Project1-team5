package com.team5.fandom.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService {
	
    private final PostRepository postRepository;
    private final CommentRepository postCommentRepository;
    private final UserRepository userRepository;
	
	
	public void registerPostComment(PostCommentDto postCommentDto) {
		User user = userRepository.getReferenceById(postCommentDto.getUserDto().getUid());
		
		Post post = postRepository.getReferenceById(postCommentDto.getPid());
		
		PostComment postComment = postCommentDto.toEntity(post, user);
		
		postCommentRepository.save(postComment);
		
	}
	
	@Transactional
	public void deletePostComment(Long pcid, String uid) {
		postCommentRepository.deleteByIdAndUser_Uid(pcid, uid);
	}
	
}
