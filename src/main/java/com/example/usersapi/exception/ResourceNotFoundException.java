package com.example.usersapi.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String entityName, Long id) {
        super(String.format("%s with id: %s not found!", entityName, id));
    }
    
}
