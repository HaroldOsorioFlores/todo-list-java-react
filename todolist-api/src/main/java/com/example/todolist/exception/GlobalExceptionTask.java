/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.todolist.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.example.todolist.dto.CustomMessageEx;

/**
 *
 * @author harold
 */
@ControllerAdvice
public class GlobalExceptionTask {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResponseNotFoundException.class)
    public ResponseEntity<CustomMessageEx> handleResponseNotFoundException(ResponseNotFoundException ex,
            WebRequest webRequest) {
        CustomMessageEx customMessageEx = new CustomMessageEx(HttpStatus.NOT_FOUND, ex.getMessage(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(customMessageEx, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomMessageEx> handleResponseNotFoundException(MethodArgumentNotValidException ex,
            WebRequest webRequest) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        CustomMessageEx customMessageEx = new CustomMessageEx(HttpStatus.BAD_REQUEST, errors.toString(),
                webRequest.getDescription(false));
        return new ResponseEntity<>(customMessageEx, HttpStatus.BAD_REQUEST);
    }
}
