package com.example.ut5_tfu_work.services.interfaces;

import com.example.ut5_tfu_work.DTOs.task.TaskRequestDTO;
import com.example.ut5_tfu_work.DTOs.task.TaskResponseDTO;

public interface TaskService {
    TaskResponseDTO create(TaskRequestDTO dto);

    TaskResponseDTO findById(Long id);
    
    void assignUser(Long taskId, Long userId);
}