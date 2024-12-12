package com.team5.fandom.repository;

import com.team5.fandom.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract class PostRepository implements JpaRepository<Post,Integer> {
}
