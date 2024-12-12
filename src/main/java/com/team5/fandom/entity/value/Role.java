package com.team5.fandom.entity.value;

public enum Role {
    USER("User"),
    ADMIN("Admin");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
