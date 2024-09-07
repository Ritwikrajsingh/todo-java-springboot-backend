package com.ritwikrajsingh.todo.dto;

import lombok.Data;

@Data
public class TodoRequestDTO {
    private String title;
    private boolean isComplete;
}
