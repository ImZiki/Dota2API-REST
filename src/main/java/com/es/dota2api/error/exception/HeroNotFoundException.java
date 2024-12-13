package com.es.dota2api.error.exception;

public class HeroNotFoundException extends RuntimeException {
    public HeroNotFoundException(String message) {
        super(message);
    }
}
