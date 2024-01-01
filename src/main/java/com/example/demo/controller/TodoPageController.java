package com.example.demo.controller;

import com.example.demo.model.TodoItemFormData;
import com.example.demo.model.TodoItemModel;
import com.example.demo.service.TodoPageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class TodoPageController {

    TodoPageService service;

    @GetMapping("/")
    public String getTodoPage(ModelMap model){
        List<TodoItemModel> todos = service.getAllTodoItems();
        model.addAttribute("todos", todos);
        model.addAttribute("totalTodoElements", todos.stream().count());
        model.addAttribute("numberOfUncompletedItems", getNumberOfUncompletedItems());
        model.addAttribute("numberOfCompletedItems", getNumberOfCompletedItems());
        model.addAttribute("item", new TodoItemFormData());
        return "todoPage";
    }

    @PostMapping("/")
    public String addNewTodoItem(@Valid @ModelAttribute("item") TodoItemFormData formData){
        service.addNewTodoItem(formData);
        return "redirect:/";
    }

    @PutMapping("/{id}/toggle")
    public String toggleSelection(@PathVariable("id") Long id){
        service.toggleTodoItem(id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id){
        service.deleteTodoItemFromDatabase(id);
        return "redirect:/";
    }

    @DeleteMapping("/deleteCompleted")
    public String deleteAllCompletedTodoItems(){
        service.deleteCompletedTodoItems();
        return "redirect:/";
    }

    private Long getNumberOfUncompletedItems() {
        return service.getUncompletedItemsFromDatabase();
    }

    private Long getNumberOfCompletedItems() {
        return service.getCompletedItemsFromDatabase();
    }

}
