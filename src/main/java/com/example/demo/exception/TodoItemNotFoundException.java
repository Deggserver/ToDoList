package com.example.demo.exception;

public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(Long id) {
        super("Could not find TodoItem " + id);
    }
}
