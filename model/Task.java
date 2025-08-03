package com.yourcompany.workforcemgmt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String id;
    private String title;
    private String assignedTo;
    private TaskPriority priority;
    private TaskStatus status;
    private LocalDate startDate;
    private List<String> comments = new ArrayList<>();
    private List<String> activityLog = new ArrayList<>();

    public void addActivity(String activity) {
        activityLog.add(LocalDate.now() + ": " + activity);
    }
}
