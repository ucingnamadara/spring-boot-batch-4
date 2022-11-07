package com.kawahedukasi.batch4.exception;

public class ValidationException extends RuntimeException{
    String message;

    public ValidationException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
