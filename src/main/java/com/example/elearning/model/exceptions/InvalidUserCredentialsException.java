package com.example.elearning.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException() {
        super("Invalid user credentials");
    }
}

