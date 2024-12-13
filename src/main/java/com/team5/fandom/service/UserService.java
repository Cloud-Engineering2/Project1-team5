package com.team5.fandom.service;

import org.springframework.stereotype.Service;

import com.team5.fandom.dto.UserDto;
import com.team5.fandom.entity.User;
import com.team5.fandom.repository.ArtistRepository;
import com.team5.fandom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	 private final UserRepository userRepository;

}
