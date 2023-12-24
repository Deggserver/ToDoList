package com.example.demo.configuration;

import com.example.demo.model.TodoItemModel;
import com.example.demo.repository.TodoItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(TodoItemRepository repository){
        return args -> {
            log.info("Loading sample data 1 " + repository.save(new TodoItemModel("Starting data 1")));
            log.info("Loading sample data 2 " + repository.save(new TodoItemModel("Starting data 2")));
            log.info("Loading sample data 3 " + repository.save(new TodoItemModel("Starting data 3")));
        };
    }
}
