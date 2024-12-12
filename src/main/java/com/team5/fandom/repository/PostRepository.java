package com.team5.fandom.repository;

import com.team5.fandom.dto.PostDto;
import com.team5.fandom.entity.Post;
import com.team5.fandom.entity.value.Tag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

	List<Post> findByFandom_FandomId(Integer fandomId);

	List<Post> findByFandom_FandomIdAndTag(Integer fandomId, Tag novel);
}