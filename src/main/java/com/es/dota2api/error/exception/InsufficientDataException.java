package com.es.dota2api.error;

public class InsufficientDataException extends RuntimeException {
    public InsufficientDataException(String message) {
        super(message);
    }
}
