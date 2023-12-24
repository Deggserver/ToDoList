package com.example.demo.controller;

import com.example.demo.exception.TodoItemNotFoundException;
import com.example.demo.model.TodoItemModel;
import com.example.demo.repository.TodoItemRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoItemController {

    private final TodoItemRepository repository;

    public TodoItemController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/todoItems")
    public TodoItemModel newTodoItem(@RequestBody @Validated TodoItemModel todoItem){
        return repository.save(todoItem);
    }

    @GetMapping("/todoItem/{id}")
    public TodoItemModel getTodoItem(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));
    }

    @GetMapping("/todoItems")
    public List<TodoItemModel> getAllTodoItems(){
        return repository.findAll();
    }

    @PutMapping("/todoItems/{id}")
    public TodoItemModel replaceTodoItem(@PathVariable Long id, @RequestBody TodoItemModel newTodoItem){
        return repository.findById(id)
                .map(todoItemElement -> {
                    todoItemElement.setTodoString(newTodoItem.getTodoString());
                    todoItemElement.setCompleted(newTodoItem.isCompleted());
                    todoItemElement.setAssignee(newTodoItem.getAssignee());
                    return repository.save(todoItemElement);
                })
                .orElseGet(() -> {
                    newTodoItem.setId(id);
                    return repository.save(newTodoItem);
                });
    }

    @DeleteMapping("/todoItems/{id}")
    public void deleteTodoItem(@PathVariable Long id){
        repository.deleteById(id);
    }
}
