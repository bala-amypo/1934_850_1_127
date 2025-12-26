package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    [cite_start]private Long id; [cite: 382]
    [cite_start]private String title; [cite: 382]
    [cite_start]private String description; [cite: 382]
    [cite_start]private String category; [cite: 382]
    [cite_start]private String channel; [cite: 382]
    [cite_start]private Integer priorityScore; [cite: 382]
    [cite_start]private LocalDateTime createdAt; [cite: 382]

    @Enumerated(EnumType.STRING)
    [cite_start]private Status status = Status.NEW; [cite: 382, 384]

    @Enumerated(EnumType.STRING)
    [cite_start]private Severity severity; [cite: 382]

    @Enumerated(EnumType.STRING)
    [cite_start]private Urgency urgency; [cite: 382]

    @ManyToOne
    [cite_start]private User customer; [cite: 382, 311]

    @ManyToOne
    [cite_start]private User assignedAgent; [cite: 382, 323]

    @ManyToMany
    @JoinTable(name = "complaint_rules")
    [cite_start]private Set<PriorityRule> priorityRules = new HashSet<>(); [cite: 382, 312, 329]

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); [cite_start]} [cite: 385]

    [cite_start]public enum Status { NEW, OPEN, IN_PROGRESS, RESOLVED } [cite: 382, 308]
    [cite_start]public enum Severity { LOW, MEDIUM, HIGH, CRITICAL } [cite: 382, 309]
    [cite_start]public enum Urgency { LOW, MEDIUM, HIGH, IMMEDIATE } [cite: 382, 310]
}