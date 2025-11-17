package com.example.ut5_tfu_user.DTOs.user;

public class UserResponseDTO {
    private Long id;
    private String username;
    private String email;

    // getters/setters.
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}