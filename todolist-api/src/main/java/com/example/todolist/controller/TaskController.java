/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.todolist.controller;

import java.util.Optional;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.dto.PageDto;
import com.example.todolist.dto.TaskDto;
import com.example.todolist.model.Task;
import com.example.todolist.servicio.TaskServiceImpl;

import jakarta.validation.Valid;

/**
 *
 * @author harold
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServiceImpl taskServiceImpl;

    public TaskController(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    @GetMapping("")
    public ResponseEntity<PageDto<Task>> getAllTasks(@ParameterObject Pageable pageable) {
        return new ResponseEntity<>(taskServiceImpl.getAllTasks(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskServiceImpl.getTaskById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody @Valid TaskDto taskDto) {
        return new ResponseEntity<>(taskServiceImpl.updateTask(taskDto, id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Task> saveTask(@RequestBody @Valid TaskDto taskDto) {
        return new ResponseEntity<>(taskServiceImpl.saveTask(taskDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTaskById(@PathVariable Long id) {
        return new ResponseEntity<>(taskServiceImpl.deleteTaskById(id), HttpStatus.OK);
    }

}
