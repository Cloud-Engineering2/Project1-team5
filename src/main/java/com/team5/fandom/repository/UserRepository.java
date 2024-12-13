package com.team5.fandom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.fandom.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
	User findByEmail(String email);

}
