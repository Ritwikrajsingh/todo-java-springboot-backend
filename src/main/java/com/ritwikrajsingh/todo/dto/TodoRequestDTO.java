package com.ritwikrajsingh.todo.dto;

import com.ritwikrajsingh.todo.entity.Todo;

import lombok.Data;

@Data
public class TodoRequestDTO {
    private String task;
    private boolean isComplete;

    public Todo toEntity() {
        return Todo.builder().task(this.task).isComplete(this.isComplete).build();
    }
}
