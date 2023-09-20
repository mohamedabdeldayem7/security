package com.workshop.security.exceptions;

import javax.validation.constraints.NotNull;

public class UserExistException extends Exception{
    public UserExistException(String message) {
        super(message);
    }
}
