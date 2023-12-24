package com.example.demo.advice;

import com.example.demo.exception.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class TodoItemNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(TodoItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String todoItemNotFoundHandler(TodoItemNotFoundException ex) {
        return ex.getMessage();
    }
}