package com.example.demo.controller;

import com.example.demo.model.TodoItemModel;
import com.example.demo.service.TodoPageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TodoPageController {

    TodoPageService service;

    @GetMapping("/")
    public String getTodoPage(ModelMap model){
        List<TodoItemModel> todos = service.getAllTodoItems();
        model.put("todos", todos);
        return "todoPage";
    }
}
