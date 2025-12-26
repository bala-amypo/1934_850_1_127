package com.example.demo.dto;

import com.example.demo.entity.User;

public class AuthResponse {
    private String token;
    private Long id;
    private String email;
    private User.Role role;

    // IMPORTANT: Add this constructor
    public AuthResponse(String token, Long id, String email, User.Role role) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.role = role;
    }

    // Getters
    public String getToken() { return token; }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public User.Role getRole() { return role; }
}