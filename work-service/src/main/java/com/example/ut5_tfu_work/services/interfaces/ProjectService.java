package com.example.ut5_tfu_work.services.interfaces;

import java.util.Set;

import com.example.ut5_tfu_work.DTOs.project.ProjectRequestDTO;
import com.example.ut5_tfu_work.DTOs.project.ProjectResponseDTO;
import com.example.ut5_tfu_work.DTOs.task.TaskResponseDTO;

public interface ProjectService {
    ProjectResponseDTO create(ProjectRequestDTO dto);

    Set<ProjectResponseDTO> findAll();

    ProjectResponseDTO findById(Long id);
    
    Set<TaskResponseDTO> findTasksByProject(Long id);
}