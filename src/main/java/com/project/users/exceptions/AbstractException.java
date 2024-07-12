package com.project.users.exceptions;

public abstract class AbstractException extends Exception {

    public AbstractException(ErrorsEnum errorsEnum) {
        super(errorsEnum.getMessage());
    }

    public AbstractException(ErrorsEnum errorsEnum, String message) {
        super(message);
    }

}
