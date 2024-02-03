package com.example.articulate.enums;

import lombok.Getter;

import static com.example.articulate.constant.Constants.ROLE.ADMIN_ROLE;
import static com.example.articulate.constant.Constants.ROLE.USER_ROLE;

@Getter
public enum PrivilegeEnum {
    USER(USER_ROLE), ADMIN(ADMIN_ROLE);
    private final String role;


    PrivilegeEnum(String role) {
        this.role = role;
    }
}
