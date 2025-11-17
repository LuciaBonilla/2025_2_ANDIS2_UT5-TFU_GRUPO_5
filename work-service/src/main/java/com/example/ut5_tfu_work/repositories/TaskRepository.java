package com.example.ut5_tfu_work.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ut5_tfu_work.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> { }