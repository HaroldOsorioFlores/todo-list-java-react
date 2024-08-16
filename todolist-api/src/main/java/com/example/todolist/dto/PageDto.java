/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.todolist.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author harold
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageDto<T> {
    private List<T> content = new ArrayList<>();
    private int totalPages;
    private int totalElements;
    private boolean first;
    private boolean last;
    private int size;
    private int number;

}
