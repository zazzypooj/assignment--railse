package com.yourcompany.workforcemgmt.controller;

import com.yourcompany.workforcemgmt.dto.CreateTaskRequest;
import com.yourcompany.workforcemgmt.dto.TaskDto;
import com.yourcompany.workforcemgmt.model.TaskPriority;
import com.yourcompany.workforcemgmt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskDto createTask(@RequestBody CreateTaskRequest request) {
        return taskService.createTask(request);
    }

    @GetMapping("/date-range")
    public List<TaskDto> getTasksByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return taskService.getTasksByDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    @PutMapping("/{taskId}/priority")
    public TaskDto updatePriority(@PathVariable String taskId, @RequestParam TaskPriority priority) {
        return taskService.updatePriority(taskId, priority);
    }

    @PostMapping("/{taskId}/comment")
    public void addComment(@PathVariable String taskId, @RequestParam String comment) {
        taskService.addComment(taskId, comment);
    }

    @GetMapping("/priority/{priority}")
    public List<TaskDto> getTasksByPriority(@PathVariable TaskPriority priority) {
        return taskService.getTasksByPriority(priority);
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskDetails(@PathVariable String taskId) {
        return taskService.getTaskById(taskId);
    }
}
