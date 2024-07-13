package com.project.users.domain.enums;

import lombok.Getter;

@Getter
public enum UserRoleCodeEnum {

    USER("USER"),
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    ;

    private final String value;

    UserRoleCodeEnum(String value) {
        this.value = value;
    }


}
