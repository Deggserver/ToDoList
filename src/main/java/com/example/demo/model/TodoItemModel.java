package com.example.demo.model;

import com.example.demo.enums.Assignee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TodoItemModel {

    @Id
    @GeneratedValue
    private Long id;
    private String todoString;
    private boolean completed;
    private Assignee assignee;

    public TodoItemModel(String todoString) {
        this.todoString = todoString;
        this.completed = false;
    }
}
