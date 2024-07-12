package com.project.users.domain.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
    ADMIN("ADMIN"),
    USER("USER"),;

    private final String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

    public static UserRoleEnum fromValue(String value) {
        for (UserRoleEnum type : values()) {
            if (type.getValue().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return USER;
    }

}
