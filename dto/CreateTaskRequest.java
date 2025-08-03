package com.yourcompany.workforcemgmt.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {
    private String title;
    private String assignedTo;
    private LocalDate startDate;
}
