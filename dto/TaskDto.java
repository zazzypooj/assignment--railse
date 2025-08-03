package com.yourcompany.workforcemgmt.dto;

import com.yourcompany.workforcemgmt.model.TaskPriority;
import com.yourcompany.workforcemgmt.model.TaskStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskDto {
    private String id;
    private String title;
    private String assignedTo;
    private TaskPriority priority;
    private TaskStatus status;
    private LocalDate startDate;
    private List<String> comments;
    private List<String> activityLog;
}
