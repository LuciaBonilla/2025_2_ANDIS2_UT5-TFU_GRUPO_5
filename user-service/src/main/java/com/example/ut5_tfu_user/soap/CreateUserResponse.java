package com.example.ut5_tfu_user.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CreateUserResponse", namespace = "http://example.com/user")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateUserResponse {

    private Long id;
    private String status;
    private String message;

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
