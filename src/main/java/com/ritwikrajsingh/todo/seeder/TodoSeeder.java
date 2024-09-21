package com.ritwikrajsingh.todo.seeder;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ritwikrajsingh.todo.entity.Todo;
import com.ritwikrajsingh.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TodoSeeder implements ApplicationRunner {
    private final TodoRepository repository;

    @Override
    public void run(ApplicationArguments args) {

        List<Todo> todos = List.of(
                Todo.builder().task("Buy groceries").isComplete(false).build(),
                Todo.builder().task("Finish Spring Boot project").isComplete(true).build(),
                Todo.builder().task("Go for a walk").isComplete(false).build(),
                Todo.builder().task("Read a book").isComplete(true).build(),
                Todo.builder().task("Water the plants").isComplete(false).build(),
                Todo.builder().task("Call mom").isComplete(true).build(),
                Todo.builder().task("Clean the house").isComplete(false).build(),
                Todo.builder().task("Pay electricity bill").isComplete(true).build(),
                Todo.builder().task("Write blog post").isComplete(false).build(),
                Todo.builder().task("Prepare dinner").isComplete(true).build());

        repository.saveAll(todos);
    }
}
