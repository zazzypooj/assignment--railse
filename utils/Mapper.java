package com.yourcompany.workforcemgmt.utils;

import com.yourcompany.workforcemgmt.dto.TaskDto;
import com.yourcompany.workforcemgmt.model.Task;

public class Mapper {
    public static TaskDto toDto(Task task) {
        TaskDto dto = new TaskDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setAssignedTo(task.getAssignedTo());
        dto.setPriority(task.getPriority());
        dto.setStatus(task.getStatus());
        dto.setStartDate(task.getStartDate());
        dto.setComments(task.getComments());
        dto.setActivityLog(task.getActivityLog());
        return dto;
    }
}
