package com.example.ut5_tfu_user.soap;

import com.example.ut5_tfu_user.models.User;        // your entity
import com.example.ut5_tfu_user.services.interfaces.UserService; // your service

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class UserSoapEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/user";

    private final UserService userService;

    public UserSoapEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CreateUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {

        System.out.println("SOAP request -> username=" + request.getUsername()
                       + ", email=" + request.getEmail());

        User user = userService.createUser(
                request.getUsername(),
                request.getEmail()
        );

        CreateUserResponse response = new CreateUserResponse();
        response.setId(user.getId());
        response.setStatus("OK");
        response.setMessage("User created successfully");
        return response;
    }
}
