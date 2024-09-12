package com.ritwikrajsingh.todo.dto;

import lombok.Data;

@Data
public class TodoPatchRequestDTO {
    private Integer id;
    private String task;
    private Boolean isComplete;
}
