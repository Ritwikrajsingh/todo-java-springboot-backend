package com.ritwikrajsingh.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;
    private String task;
    private Boolean isComplete;
}
