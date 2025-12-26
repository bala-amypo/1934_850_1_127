package com.example.demo.service;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import java.util.List;

public interface ComplaintService {
    // Maps DTO to Entity, triggers scoring, and saves to DB
    Complaint submitComplaint(ComplaintRequest request, User customer);
    
    // Retrieves history for a specific logged-in customer
    List<Complaint> getComplaintsForUser(User customer);
    
    // Retrieves all complaints sorted by Priority Score (HQL requirement)
    List<Complaint> getPrioritizedComplaints();
}