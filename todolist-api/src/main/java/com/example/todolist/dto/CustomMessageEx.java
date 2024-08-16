/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.todolist.dto;

import java.time.Instant;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author harold
 */

@Getter
@Setter
public class CustomMessageEx {
    private Instant timestamp = Instant.now();
    private int status;
    private HttpStatus error;
    private String message;
    private String path;

    public CustomMessageEx(HttpStatus error, String message, String path) {
        this.status = error.value();
        this.error = error;
        this.message = message;
        this.path = path.replace("uri=", "");
    }
}
