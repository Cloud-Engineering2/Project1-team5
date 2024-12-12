package com.team5.fandom.dto;

import com.team5.fandom.entity.Fandom;
import com.team5.fandom.entity.User;
import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDto {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private Role role;
    private Level fanLevel;
    private Integer fanExp;
    private Integer fandomId;

    public static UserDto of(String userName, String email, String password, Role role, Level fanLevel, Integer fanExp, Integer fandomId) {
        return new UserDto(null, userName, email, password, role, fanLevel, fanExp, fandomId);
    }

    public static UserDto from(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                user.getFanLevel(),
                user.getFanExp(),
                user.getFandom() != null ? user.getFandom().getFandomId() : null
        );
    }

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
