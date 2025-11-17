package com.example.ut5_tfu_work.models;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    // Instead of ManyToMany with User, store only user IDs
    @ElementCollection
    @CollectionTable(
        name = "task_users",
        joinColumns = @JoinColumn(name = "task_id")
    )
    @Column(name = "user_id")
    private Set<Long> userIds = new HashSet<>();

    public Task() {}

    public Task(String title, String status, Project project) {
        this.title = title;
        this.status = status;
        this.project = project;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    public Set<Long> getUserIds() { return userIds; }
    public void setUserIds(Set<Long> userIds) { this.userIds = userIds; }

    public void addUserId(Long userId) {
        this.userIds.add(userId);
    }

    public void removeUserId(Long userId) {
        this.userIds.remove(userId);
    }
}
