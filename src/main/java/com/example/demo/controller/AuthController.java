package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        // Dummy token generation for now
        String token = "dummy-jwt-token-for-" + request.getEmail();
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return response;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody AuthRequest request) {
        // Dummy registration
        String token = "registered-dummy-jwt-token-for-" + request.getEmail();
        AuthResponse response = new AuthResponse();
        response.setToken(token);
        return response;
    }
}
