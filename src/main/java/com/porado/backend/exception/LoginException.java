package com.porado.backend.exception;

public class LoginException extends RuntimeException {
    public LoginException(String message) {
        super(message);
    }
}
