package com.example.demo.dto;

import com.example.demo.entity.Complaint;

import java.time.LocalDateTime;

public class ComplaintResponse {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String channel;
    private Integer priorityScore;
    private LocalDateTime createdAt;
    private Complaint.Status status;
    private Complaint.Severity severity;
    private Complaint.Urgency urgency;
    private Long customerId;
    private Long assignedAgentId;

    // Getters and setters
    // ...
}
