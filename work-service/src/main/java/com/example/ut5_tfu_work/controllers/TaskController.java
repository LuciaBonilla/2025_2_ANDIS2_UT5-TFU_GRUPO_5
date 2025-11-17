package com.example.ut5_tfu_work.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ut5_tfu_work.DTOs.task.TaskRequestDTO;
import com.example.ut5_tfu_work.DTOs.task.TaskResponseDTO;
import com.example.ut5_tfu_work.services.interfaces.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService svc;
    public TaskController(TaskService svc) { this.svc = svc; }

    @PostMapping
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO dto) {
        return ResponseEntity.status(201).body(svc.create(dto));
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(svc.findById(id));
    }

    @PostMapping("{taskId}/users/{userId}")
    public ResponseEntity<Void> assignUser(@PathVariable Long taskId, @PathVariable Long userId) {
        svc.assignUser(taskId, userId);
        return ResponseEntity.status(204).build();
    }
}
