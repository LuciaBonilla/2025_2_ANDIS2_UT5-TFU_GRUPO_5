package com.example.ut5_tfu_user.services.interfaces;

import java.util.Set;

import com.example.ut5_tfu_user.DTOs.user.UserRequestDTO;
import com.example.ut5_tfu_user.DTOs.user.UserResponseDTO;
import com.example.ut5_tfu_user.models.User;

public interface UserService {
    UserResponseDTO create(UserRequestDTO dto);

    Set<UserResponseDTO> findAll();
    
    UserResponseDTO findById(Long id);

    // Para endpoint SOAP
    User createUser(String username, String email);
}