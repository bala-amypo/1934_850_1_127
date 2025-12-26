package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class PriorityRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // e.g., SEVERITY or URGENCY
    private String level; // e.g., CRITICAL, HIGH, LOW
    private Double weight;
    
    // ADDED: Required by test cases
    private String description; 

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
    
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    // ADDED: Missing getter/setter for description
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}