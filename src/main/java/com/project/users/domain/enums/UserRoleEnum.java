package com.project.users.domain.enums;

import com.project.users.domain.enums.config.UserRoleEnumConfig;

public record UserRoleEnum(String value) {

    public static UserRoleEnum fromValue(String value) {
        for (String groupRole : UserRoleEnumConfig.roles) {
            if (groupRole.equalsIgnoreCase(value)) {
                return new UserRoleEnum(value);
            }
        }
        return null;
    }

}
