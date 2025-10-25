package com.nordic.tinyurl.exception;

public class ShorteningCollisionException extends RuntimeException {
    public ShorteningCollisionException(String message) {
        super(message);
    }
}
