package com.example.demo.repository;

import com.example.demo.model.TodoItemModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItemModel, Long> {
}
