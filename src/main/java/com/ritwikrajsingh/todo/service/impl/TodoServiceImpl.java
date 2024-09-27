package com.ritwikrajsingh.todo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ritwikrajsingh.todo.dto.TodoPatchRequestDTO;
import com.ritwikrajsingh.todo.dto.TodoRequestDTO;
import com.ritwikrajsingh.todo.dto.TodoResponseDTO;
import com.ritwikrajsingh.todo.entity.Todo;
import com.ritwikrajsingh.todo.repository.TodoRepository;
import com.ritwikrajsingh.todo.service.TodoService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository repository;

    @Override
    public TodoResponseDTO createTodo(TodoRequestDTO dto) {
        return TodoResponseDTO.fromEntity(this.repository.save(dto.toEntity()));
    }

    @Override
    public List<TodoResponseDTO> getAllTodos() {
        return this.repository.findAll().stream().map(TodoResponseDTO::fromEntity).toList();
    }

    @Override
    public TodoResponseDTO updateTodoById(Integer id, TodoRequestDTO dto) {
        Todo entity = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));

        entity.setTask(dto.getTask());
        entity.setIsComplete(dto.getIsComplete());

        return TodoResponseDTO.fromEntity(this.repository.save(entity));
    }

    @Override
    public TodoResponseDTO patchTodoById(Integer id, TodoPatchRequestDTO dto) {
        Todo entity = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));

        if (dto.getTask() == null && dto.getIsComplete() == null) {
            throw new IllegalArgumentException("At least one field must be provided for update.");
        }

        if (dto.getTask() != null) {
            entity.setTask(dto.getTask());
        }

        if (dto.getIsComplete() != null) {
            entity.setIsComplete(dto.getIsComplete());
        }

        return TodoResponseDTO.fromEntity(this.repository.save(entity));
    }

    @Override
    public void deleteTodoById(Integer id) {
        Todo entity = this.repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));

        this.repository.delete(entity);
    }
}
