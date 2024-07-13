package com.project.users.domain.enums;

import com.project.users.domain.enums.config.UserPermissionEnumConfig;

public record UserPermissionEnum(String value) {

    public static UserPermissionEnum fromValue(String value) {
        for (String permission : UserPermissionEnumConfig.permissionsSet) {
            if (permission.equalsIgnoreCase(value)) {
                return new UserPermissionEnum(value);
            }
        }
        return null;
    }

}
