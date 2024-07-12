package com.project.users.domain.enums.converters;

import com.project.users.domain.enums.UserRoleEnum;
import jakarta.persistence.AttributeConverter;

public class UserRoleEnumConverter implements AttributeConverter<UserRoleEnum, String> {

    @Override
    public String convertToDatabaseColumn(UserRoleEnum attribute) {
        return attribute.getValue();
    }

    @Override
    public UserRoleEnum convertToEntityAttribute(String dbData) {
        return UserRoleEnum.fromValue(dbData);
    }

}
