package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email (matches User entity field)
    Optional<User> findByEmail(String email);

    // Check if email exists (useful for registration)
    boolean existsByEmail(String email);
}
