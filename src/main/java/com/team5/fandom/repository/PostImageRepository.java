package com.team5.fandom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.PostImage;

@Repository
public interface PostImageRepository extends JpaRepository<PostImage, Integer> {
    List<PostImage> findByPost(Post post);
    Optional<PostImage> findByPost_PostId(Integer postId);
}