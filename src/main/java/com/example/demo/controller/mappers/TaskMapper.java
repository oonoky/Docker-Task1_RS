package com.example.demo.controller.mappers;

import com.example.demo.controller.dtos.TaskDto;
import com.example.demo.model.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper extends Mappable<Task, TaskDto>{
}