package com.yourcompany.workforcemgmt.service;

import com.yourcompany.workforcemgmt.dto.CreateTaskRequest;
import com.yourcompany.workforcemgmt.dto.TaskDto;
import com.yourcompany.workforcemgmt.model.Task;
import com.yourcompany.workforcemgmt.model.TaskPriority;
import com.yourcompany.workforcemgmt.model.TaskStatus;
import com.yourcompany.workforcemgmt.utils.Mapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final Map<String, Task> taskStorage = new HashMap<>();

    public TaskDto createTask(CreateTaskRequest request) {
        Task task = new Task(UUID.randomUUID().toString(), request.getTitle(), request.getAssignedTo(),
                TaskPriority.MEDIUM, TaskStatus.ACTIVE, request.getStartDate());
        task.addActivity("Task created by " + request.getAssignedTo());
        taskStorage.put(task.getId(), task);
        return Mapper.toDto(task);
    }

    public List<TaskDto> getTasksByDateRange(LocalDate start, LocalDate end) {
        return taskStorage.values().stream()
                .filter(t -> t.getStatus() != TaskStatus.CANCELLED &&
                        (t.getStartDate().isAfter(start.minusDays(1)) && t.getStartDate().isBefore(end.plusDays(1)) ||
                        (t.getStartDate().isBefore(start) && t.getStatus() == TaskStatus.ACTIVE)))
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskDto updatePriority(String id, TaskPriority priority) {
        Task task = taskStorage.get(id);
        task.setPriority(priority);
        task.addActivity("Priority updated to " + priority);
        return Mapper.toDto(task);
    }

    public void addComment(String id, String comment) {
        Task task = taskStorage.get(id);
        task.getComments().add(comment);
        task.addActivity("Comment added: " + comment);
    }

    public List<TaskDto> getTasksByPriority(TaskPriority priority) {
        return taskStorage.values().stream()
                .filter(task -> task.getPriority() == priority)
                .map(Mapper::toDto)
                .collect(Collectors.toList());
    }

    public TaskDto getTaskById(String id) {
        return Mapper.toDto(taskStorage.get(id));
    }
}
