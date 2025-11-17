package com.example.ut5_tfu_user.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ut5_tfu_user.DTOs.user.UserRequestDTO;
import com.example.ut5_tfu_user.DTOs.user.UserResponseDTO;
import com.example.ut5_tfu_user.exceptions.ResourceNotFoundException;
import com.example.ut5_tfu_user.models.User;
import com.example.ut5_tfu_user.repositories.UserRepository;
import com.example.ut5_tfu_user.services.interfaces.UserService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository repo;
    public UserServiceImpl(UserRepository repo) { this.repo = repo; }

    @Override
    @Transactional
    public UserResponseDTO create(UserRequestDTO dto) {
        User user = new User(dto.getUsername(), dto.getEmail());
        user = repo.save(user);
        return toResponseDTO(user);
    }

    @Override
    public Set<UserResponseDTO> findAll() {
        return repo.findAll().stream().map(this::toResponseDTO).collect(Collectors.toSet());
    }

    @Override
    public UserResponseDTO findById(Long id) {
        return repo.findById(id).map(this::toResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + id));
    }

    public UserResponseDTO toResponseDTO(User u) {
        UserResponseDTO r = new UserResponseDTO();
        r.setId(u.getId()); r.setUsername(u.getUsername()); r.setEmail(u.getEmail());
        return r;
    }

    // Para endpoint SOAP
    @Override
    @Transactional
    public User createUser(String username, String email) {
        User user = new User(username, email);
        user = repo.save(user);
        return user;
    }
}