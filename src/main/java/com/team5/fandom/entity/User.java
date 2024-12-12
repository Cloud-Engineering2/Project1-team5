package com.team5.fandom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user")
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
    private FanLevel fanLevel;

    @Column(name = "fan_exp", nullable = false)
    private Integer fanExp;

    @ManyToOne
    @JoinColumn(name = "fandom_id")
    private Fandom fandom;

}

enum Role {
    USER, ADMIN
}

enum FanLevel {
    BRONZE, SILVER, GOLD, PLATINUM, DIAMOND
}

