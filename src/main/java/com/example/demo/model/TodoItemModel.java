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
    private String task;
    private boolean completed;
    private Assignee assignee;

    public TodoItemModel(String task) {
        this.task = task;
        this.completed = false;
    }

    public TodoItemModel(TodoItemFormData formData) {
        this.task = formData.getTask();
        this.completed = false;
        this.assignee = null;
    }
}
