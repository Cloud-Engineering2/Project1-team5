package com.team5.fandom.entity;

import java.util.Objects;

import com.team5.fandom.entity.value.Level;
import com.team5.fandom.entity.value.Role;
import com.team5.fandom.entity.value.Tag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "fan_level", nullable = false)
    private Level fanLevel;

    @Column(name = "fan_exp", nullable = false)
    private Integer fanExp;

    @ManyToOne
    @JoinColumn(name = "fandom_id")
    private Fandom fandom;

    //No ID
    public static User of( String userName, String email, String password, Role role, Level fanLevel, Integer fanExp, Fandom fandom) {
        return new User(null, userName, email, password, role, fanLevel, fanExp, fandom);
    }
    
    //With ID
    public static User of(Integer userId, String userName, String email, String password, Role role, Level fanLevel, Integer fanExp, Fandom fandom) {
        return new User(userId, userName, email, password, role, fanLevel, fanExp, fandom);
    }

    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User that)) return false;
        return this.getUserId() != null && this.getUserId().equals(that.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId());
    }
     
    
}


