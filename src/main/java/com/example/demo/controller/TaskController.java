package com.example.demo.controller;

import com.example.demo.controller.dtos.TaskDto;
import com.example.demo.controller.mappers.TaskMapper;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable("id") Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        Task updatedTask = taskMapper.toEntity(taskDto);
        Task task = taskRepository.findById(id).orElseThrow();

        task.setDeadlineDate(updatedTask.getDeadlineDate());
        task.setTitle(updatedTask.getTitle());
        task.setStatus(updatedTask.getStatus());
        task.setDescription(updatedTask.getDescription());

        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
