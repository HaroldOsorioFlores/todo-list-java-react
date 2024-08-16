/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.todolist.exception;

/**
 *
 * @author harold
 */
public class ResponseNotFoundException extends RuntimeException {

    public ResponseNotFoundException(String message) {
        super(message);
    }

}
