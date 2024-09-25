package com.ritwikrajsingh.todo.service;

import java.util.List;

import com.ritwikrajsingh.todo.dto.TodoPatchRequestDTO;
import com.ritwikrajsingh.todo.dto.TodoRequestDTO;
import com.ritwikrajsingh.todo.dto.TodoResponseDTO;

public interface TodoService {
    public TodoResponseDTO createTodo(TodoRequestDTO dto);

    public List<TodoResponseDTO> getAllTodos();

    public TodoResponseDTO updateTodoById(Integer id, TodoRequestDTO dto);

    public TodoResponseDTO patchTodoById(Integer id, TodoPatchRequestDTO dto);

    public void deleteTodoById(Integer id);
}
