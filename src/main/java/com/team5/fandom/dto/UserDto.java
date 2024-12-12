package com.team5.fandom.dto;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class UserDto {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private Role role;
    private Level fanLevel;
    private Integer fanExp;
    private Integer fandomId;

    // 빌더를 활용한 정적 팩토리 메서드
    public static UserDto of(String userName, String email, String password, Role role, Level fanLevel, Integer fanExp, Integer fandomId) {
        return UserDto.builder()
                .userName(userName)
                .email(email)
                .password(password)
                .role(role)
                .fanLevel(fanLevel)
                .fanExp(fanExp)
                .fandomId(fandomId)
                .build();
    }

    // Entity -> DTO 변환
    public static UserDto from(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .fanLevel(user.getFanLevel())
                .fanExp(user.getFanExp())
                .fandomId(user.getFandom() != null ? user.getFandom().getFandomId() : null)
                .build();
    }
    
    

    // DTO -> Entity 변환
    public User toEntity(Fandom fandom) {
        return User.of(
                userName,
                email,
                password,
                role,
                fanLevel,
                fanExp,
                fandom
        );
    }
}
