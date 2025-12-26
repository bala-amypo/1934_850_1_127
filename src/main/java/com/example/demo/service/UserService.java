package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    // Used by AuthController and tests for registration
    User registerCustomer(String name, String email, String password);
    
    // Used by Security layer to find users during login
    User findByEmail(String email);
}