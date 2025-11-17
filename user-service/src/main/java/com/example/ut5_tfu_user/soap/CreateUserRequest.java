package com.example.ut5_tfu_user.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreateUserRequest", namespace = "http://example.com/user")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateUserRequest {

    private String username;
    private String email;

    // getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
