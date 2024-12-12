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
    private FandomDto fandomDto;


    private UserDto(Integer userId, String userName, String email, String password, Role role, Level fanLevel, Integer fanExp, FandomDto fandomDto) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.fanLevel = fanLevel;
        this.fanExp = fanExp;
        this.fandomDto = fandomDto;
    }



    // Entity -> DTO 변환
    public static UserDto toUserDto(User user) {
        return new UserDto(
        user.getUserId(),
        user.getUserName(),
        user.getEmail(),
        user.getPassword(),
        user.getRole(),
        user.getFanLevel(),
        user.getFanExp(),
        FandomDto.toFandomDto(user.getFandom()));
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