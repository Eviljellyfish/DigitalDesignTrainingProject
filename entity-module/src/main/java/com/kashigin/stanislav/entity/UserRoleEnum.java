package com.kashigin.stanislav.entity;

public enum UserRoleEnum {
    USER(1),
    MODERATOR(2),
    ADMIN(3);

    private final int value;

    UserRoleEnum(int v) {
        this.value = v;
    }

    public int getValue() {
        return value;
    }

}
