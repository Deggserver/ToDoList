package com.example.demo.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class TodoItemFormData {
    @NonNull
    private String task;
}
