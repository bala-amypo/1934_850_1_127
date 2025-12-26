package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "complaint_priority_rules")
public class ComplaintPriorityRules {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    // ADDED: Explicit column mapping to ensure data.sql matches
    @Column(name = "base_weight")
    private Double baseWeight;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Double getBaseWeight() { return baseWeight; }
    public void setBaseWeight(Double baseWeight) { this.baseWeight = baseWeight; }
}