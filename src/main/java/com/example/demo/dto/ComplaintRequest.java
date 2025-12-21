package com.example.demo.dto;

public class ComplaintRequest {
    private String title;
    private String description;
    private String category;
    private String channel;
    private String severity; // must match enum names exactly
    private String urgency;  // must match enum names exactly
    private Long customerId; // must exist in DB

    // Add getters and setters for all fields
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public String getChannel() { return channel; }
    public String getSeverity() { return severity; }
    public String getUrgency() { return urgency; }
    public Long getCustomerId() { return customerId; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCategory(String category) { this.category = category; }
    public void setChannel(String channel) { this.channel = channel; }
    public void setSeverity(String severity) { this.severity = severity; }
    public void setUrgency(String urgency) { this.urgency = urgency; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }
}
