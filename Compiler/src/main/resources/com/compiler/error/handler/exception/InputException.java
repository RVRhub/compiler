package com.compiler.error.handler.exception;

public class InputException extends Exception {

    public InputException() {
    }

    // Constructor that accepts a message
    public  InputException(String message) {
        super(message);
    }
}
