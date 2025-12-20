package com.example.demo.service;

import com.example.demo.entity.Complaint;

import java.util.List;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
    List<Complaint> getComplaintsByPriorityScore(Integer priorityScore);
    List<Complaint> getComplaintsBySeverity(Complaint.Severity severity);
    List<Complaint> getComplaintsByUrgency(Complaint.Urgency urgency);
}
