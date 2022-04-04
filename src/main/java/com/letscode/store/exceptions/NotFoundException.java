package com.letscode.store.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String message){
        super(message + " não encontrado.");
    }
}