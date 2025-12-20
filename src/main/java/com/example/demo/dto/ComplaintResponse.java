package com.example.demo.dto;

import com.example.demo.entity.Complaint;

public class ComplaintResponse {
    private Long id;
    private String title;
    private String status;
    private int priorityScore;

    public ComplaintResponse() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getPriorityScore() { return priorityScore; }
    public void setPriorityScore(int priorityScore) { this.priorityScore = priorityScore; }
}
