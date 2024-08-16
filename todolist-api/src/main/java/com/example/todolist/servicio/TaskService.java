/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.example.todolist.servicio;

import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.example.todolist.dto.PageDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.model.Task;

/**
 *
 * @author harold
 */
public interface TaskService {
    public PageDto<Task> getAllTasks(Pageable pageable);

    public Optional<Task> getTaskById(Long id);

    public Task saveTask(TaskDto taskDto);

    public Task updateTask(TaskDto taskDto, Long id);

    public String deleteTaskById(Long id);
}
