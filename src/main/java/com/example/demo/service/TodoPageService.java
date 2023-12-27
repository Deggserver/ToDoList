package com.example.demo.service;

import com.example.demo.model.TodoItemFormData;
import com.example.demo.model.TodoItemModel;
import com.example.demo.repository.TodoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoPageService {
    TodoItemRepository repository;

    public List<TodoItemModel> getAllTodoItems(){
        return repository.findAll();
    }

    public void addNewTodoItem(TodoItemFormData formData) {
        TodoItemModel newTodo = new TodoItemModel(formData);
        repository.save(newTodo);
    }
}

