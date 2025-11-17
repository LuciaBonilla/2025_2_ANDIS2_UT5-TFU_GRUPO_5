package com.example.ut5_tfu_work.DTOs.task;

import java.util.HashSet;
import java.util.Set;

public class TaskResponseDTO {
    private Long id;
    private String title;
    private String status;
    private Long projectId;
    // Sólo user IDs, no UserResponseDTO
    private Set<Long> userIds = new HashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public Set<Long> getUserIds() { return userIds; }
    public void setUserIds(Set<Long> userIds) { this.userIds = userIds; }
}
