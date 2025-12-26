package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class PriorityRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    [cite_start]private Long id; [cite: 389]
    [cite_start]private String ruleName; [cite: 389]
    [cite_start]private String description; [cite: 389]
    [cite_start]private Integer weight; [cite: 389]
    [cite_start]private boolean active = true; [cite: 389, 391]

    @ManyToMany(mappedBy = "priorityRules")
    [cite_start]private Set<Complaint> complaints = new HashSet<>(); [cite: 389, 324]
}