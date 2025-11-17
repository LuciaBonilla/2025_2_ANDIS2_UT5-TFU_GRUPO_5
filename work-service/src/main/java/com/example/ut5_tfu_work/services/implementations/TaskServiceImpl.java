package com.example.ut5_tfu_work.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ut5_tfu_work.DTOs.task.TaskRequestDTO;
import com.example.ut5_tfu_work.DTOs.task.TaskResponseDTO;
import com.example.ut5_tfu_work.exceptions.ResourceNotFoundException;
import com.example.ut5_tfu_work.models.Project;
import com.example.ut5_tfu_work.models.Task;
import com.example.ut5_tfu_work.repositories.ProjectRepository;
import com.example.ut5_tfu_work.repositories.TaskRepository;
import com.example.ut5_tfu_work.services.interfaces.TaskService;

import java.util.HashSet;

@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepo;
    private final ProjectRepository projectRepo;

    public TaskServiceImpl(TaskRepository taskRepo, ProjectRepository projectRepo) {
        this.taskRepo = taskRepo;
        this.projectRepo = projectRepo;
    }

    @Override
    @Transactional
    public TaskResponseDTO create(TaskRequestDTO dto) {
        Project project = projectRepo.findById(dto.getProjectId())
                .orElseThrow(() -> new ResourceNotFoundException("Project not found: " + dto.getProjectId()));

        Task t = new Task(dto.getTitle(), dto.getStatus(), project);
        t = taskRepo.save(t);

        // optional: keep bidirectional association with project if you want
        project.getTasks().add(t);

        return toResponseDTO(t);
    }

    @Override
    public TaskResponseDTO findById(Long id) {
        Task t = taskRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + id));
        return toResponseDTO(t);
    }

    @Override
    @Transactional
    public void assignUser(Long taskId, Long userId) {
        Task t = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found: " + taskId));

        // Here you could optionally call user-service via HTTP to validate userId
        if (!t.getUserIds().contains(userId)) {
            t.addUserId(userId);
            taskRepo.save(t);
        }
    }

    public TaskResponseDTO toResponseDTO(Task t) {
        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setId(t.getId());
        dto.setTitle(t.getTitle());
        dto.setStatus(t.getStatus());
        dto.setProjectId(t.getProject() != null ? t.getProject().getId() : null);
        dto.setUserIds(new HashSet<>(t.getUserIds()));
        return dto;
    }
}
