package com.ritwikrajsingh.todo.dto;

import com.ritwikrajsingh.todo.entity.Todo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TodoRequestDTO {
    @NotNull(message = "Task cannot be null.")
    @NotEmpty(message = "Task cannot be empty.")
    private String task;
    private boolean isComplete;

    public Todo toEntity() {
        return Todo.builder().task(this.task).isComplete(this.isComplete).build();
    }
}
