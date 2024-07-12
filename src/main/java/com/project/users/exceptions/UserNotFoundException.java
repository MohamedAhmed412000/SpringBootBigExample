package com.project.users.exceptions;

public class UserNotFoundException extends AbstractException {

    public UserNotFoundException() {
        super(ErrorsEnum.USER_NOT_FOUND_EXCEPTION);
    }

    public UserNotFoundException(String message) {
        super(ErrorsEnum.USER_NOT_FOUND_EXCEPTION, message);
    }

}
