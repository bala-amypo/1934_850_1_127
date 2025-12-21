package com.example.demo.dto;

import com.example.demo.entity.Complaint;
import java.time.LocalDateTime;

public class ComplaintResponse {

    private Long id;
    private String title;
    private String category;
    private String channel;
    private Integer priorityScore;
    private String status;
    private String severity;
    private String urgency;
    private LocalDateTime createdAt;
    private Long customerId;
    private String message; // for errors or info

    // Default constructor
    public ComplaintResponse() {}

    // Constructor mapping from entity
    public ComplaintResponse(Complaint c) {
        if (c != null) {
            this.id = c.getId();
            this.title = c.getTitle();
            this.category = c.getCategory();
            this.channel = c.getChannel();
            this.priorityScore = c.getPriorityScore();
            this.status = c.getStatus() != null ? c.getStatus().name() : null;
            this.severity = c.getSeverity() != null ? c.getSeverity().name() : null;
            this.urgency = c.getUrgency() != null ? c.getUrgency().name() : null;
            this.createdAt = c.getCreatedAt();
            this.customerId = c.getCustomer() != null ? c.getCustomer().getId() : null;
        }
    }

    // Factory method for message-only responses
    public static ComplaintResponse withMessage(String message) {
        ComplaintResponse response = new ComplaintResponse();
        response.message = message;
        return response;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public String getChannel() { return channel; }
    public Integer getPriorityScore() { return priorityScore; }
    public String getStatus() { return status; }
    public String getSeverity() { return severity; }
    public String getUrgency() { return urgency; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Long getCustomerId() { return customerId; }
    public String getMessage() { return message; }
}
