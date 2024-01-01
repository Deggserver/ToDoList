package com.example.demo.service;

import com.example.demo.exception.TodoItemNotFoundException;
import com.example.demo.model.TodoItemFormData;
import com.example.demo.model.TodoItemModel;
import com.example.demo.repository.TodoItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoPageService {
    TodoItemRepository repository;

    public List<TodoItemModel> getAllTodoItems() {
        return repository.findAll();
    }

    public void addNewTodoItem(TodoItemFormData formData) {
        TodoItemModel newTodo = new TodoItemModel(formData);
        repository.save(newTodo);
    }

    public void toggleTodoItem(Long id) {
        TodoItemModel todoItem = repository.findById(id)
                                          .orElseThrow(() -> new TodoItemNotFoundException(id));
        todoItem.setCompleted(!todoItem.isCompleted());
        repository.save(todoItem);
    }

    public void deleteTodoItemFromDatabase(Long id) {
        repository.deleteById(id);
    }

    public void deleteCompletedTodoItems() {
        List<TodoItemModel> completedTodoItems = repository.findAll().stream().filter(element -> element.isCompleted())
                                                                              .collect(Collectors.toList());
        for(TodoItemModel element : completedTodoItems) {
            repository.delete(element);
        }
    }

    public Long getUncompletedItemsFromDatabase() {
        return repository.findAll().stream().filter(element -> !element.isCompleted())
                                            .count();
    }

    public Long getCompletedItemsFromDatabase() {
        return repository.findAll().stream().filter(element -> element.isCompleted())
                                            .count();
    }
}

