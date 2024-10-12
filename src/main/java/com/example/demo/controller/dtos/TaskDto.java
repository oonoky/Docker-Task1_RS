package com.example.demo.controller.dtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadlineDate;
    private int status;
}