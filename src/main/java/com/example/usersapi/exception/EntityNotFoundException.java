package com.example.usersapi.exception;

public class EntityNotFoundException extends RuntimeException {
    
    public EntityNotFoundException(String entityName, Long id) {
        super(String.format("%s with id: %s not found!", entityName, id));
    }
    
}
