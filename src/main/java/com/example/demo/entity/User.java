package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    [cite_start]private Long id; [cite: 376]

    [cite_start]private String fullName; [cite: 376]

    @Column(unique = true, nullable = false)
    [cite_start]private String email; [cite: 376, 378]

    [cite_start]private String password; [cite: 376]

    @Enumerated(EnumType.STRING)
    [cite_start]private Role role; [cite: 376]

    [cite_start]public enum Role { CUSTOMER, AGENT, ADMIN } [cite: 376]
}