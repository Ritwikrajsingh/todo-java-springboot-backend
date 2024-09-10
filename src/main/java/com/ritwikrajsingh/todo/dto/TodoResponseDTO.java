package com.ritwikrajsingh.todo.dto;

import com.ritwikrajsingh.todo.entity.Todo;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TodoResponseDTO {
    private Integer id;
    private String task;
    private Boolean isComplete;

    public static TodoResponseDTO fromEntity(Todo todo) {
        return TodoResponseDTO.builder()
                .id(todo.getId())
                .task(todo.getTask())
                .isComplete(todo.getIsComplete())
                .build();
    }
}
