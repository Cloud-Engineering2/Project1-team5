package com.team5.fandom.security;

import com.team5.fandom.dto.UserDto;
import com.team5.fandom.entity.value.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class FanUserDetails implements UserDetails {

    private Integer userId;
    private String userName;
    private String email;
    private String password;
    private Role role;

    public static FanUserDetails of(Integer userId, String userName, String email,String password,Role role) {
        return new FanUserDetails(userId, userName, email, password, role);
    }

    public static FanUserDetails toFUDto(UserDto userDto) {
        return FanUserDetails.of(userDto.getUserId(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getRole());
    }

    public UserDto toUserDto() {
        return UserDto.of(
                userId,
                userName,
                email,
                password,
                role
        );
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { // 권힌
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> role.getRoleName());
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + role.getRoleName())
        );
    }

    @Override
    public String getPassword() {
        return password; 
    }

    @Override
    public String getUsername() {
        return email;
    }
}
