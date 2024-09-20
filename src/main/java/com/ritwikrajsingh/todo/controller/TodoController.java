package com.ritwikrajsingh.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritwikrajsingh.todo.dto.TodoPatchRequestDTO;
import com.ritwikrajsingh.todo.dto.TodoRequestDTO;
import com.ritwikrajsingh.todo.dto.TodoResponseDTO;
import com.ritwikrajsingh.todo.service.impl.TodoServiceImpl;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/todo")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class TodoController {
    private final TodoServiceImpl service;

    @PostMapping
    public ResponseEntity<TodoResponseDTO> createTodo(@RequestBody @Valid TodoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createTodo(dto));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponseDTO>> getAllTodos() {
        return ResponseEntity.ok(this.service.getAllTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> updateTodoById(@PathVariable Integer id,
            @RequestBody @Valid TodoRequestDTO dto) {
        return ResponseEntity.ok(this.service.updateTodoById(id, dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponseDTO> patchTodoById(@PathVariable Integer id,
            @RequestBody TodoPatchRequestDTO dto) {
        return ResponseEntity.ok(this.service.patchTodoById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Integer id) {
        this.service.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}
