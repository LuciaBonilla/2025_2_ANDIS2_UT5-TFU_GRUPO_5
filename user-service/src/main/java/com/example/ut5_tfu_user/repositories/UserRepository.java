package com.example.ut5_tfu_user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ut5_tfu_user.models.User;

public interface UserRepository extends JpaRepository<User, Long> { }