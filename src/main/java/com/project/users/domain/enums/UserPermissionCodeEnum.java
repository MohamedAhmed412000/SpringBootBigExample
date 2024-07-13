package com.project.users.domain.enums;

import lombok.Getter;

@Getter
public enum UserPermissionCodeEnum {

    READ("READ"),
    WRITE("WRITE"),
    MODIFY("MODIFY"),
    DELETE("DELETE"),
    ;

    private final String value;

    UserPermissionCodeEnum(String value) {
        this.value = value;
    }


}
