package com.team5.fandom.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.team5.fandom.dto.UserDto;
import com.team5.fandom.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;



    public Optional<UserDto> searchUserByEmail(String email) {
        return userRepository.findByEmail(email).map(UserDto::toUserDto);
    }
}