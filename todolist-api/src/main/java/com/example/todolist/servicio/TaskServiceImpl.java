/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.todolist.servicio;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.todolist.dto.PageDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.exception.ResponseNotFoundException;
import com.example.todolist.model.Task;
import com.example.todolist.repository.TaskRepository;

/**
 *
 * @author harold
 */
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public PageDto<Task> getAllTasks(Pageable pageable) {
        Page<Task> page = taskRepository.findAll(pageable);
        return new PageDto<>(page.getContent(), page.getNumberOfElements(), page.getTotalPages(), page.isFirst(),
                page.isLast(), page.getSize(), page.getNumber());
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (!task.isPresent()) {
            throw new ResponseNotFoundException("Task not found");
        }
        return task;
    }

    @Override
    public Task updateTask(TaskDto taskDto, Long id) {
        Optional<Task> task = this.getTaskById(id);
        task.get().setTitle(taskDto.getTitle());
        task.get().setDescription(taskDto.getDescription());
        task.get().setState(taskDto.getState());
        return task.get();
    }

    @Override
    public Task saveTask(TaskDto taskDto) {
        Task task = new Task(taskDto.getTitle(), taskDto.getDescription(), taskDto.getState());
        return taskRepository.save(task);
    }

    @Override
    public String deleteTaskById(Long id) {
        this.getTaskById(id); // pongo esto porque despues se realizara validaciones con excepciones
        taskRepository.deleteById(id);
        return "Deleted Task";
    }

}
