package com.es.dota2api.error;

public class InvalidHeroDataException extends RuntimeException {
    public InvalidHeroDataException(String message) {
        super(message);
    }
}
