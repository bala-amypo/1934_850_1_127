package com.example.demo.service;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import java.util.List;
import java.util.Optional;

public interface ComplaintService {
    Complaint submitComplaint(ComplaintRequest request, User customer);
    
    List<Complaint> getComplaintsForUser(User customer);
    
    List<Complaint> getPrioritizedComplaints();

    // MUST ADD THESE TWO TO FIX THE COMPILATION ERROR
    Optional<Complaint> getComplaintById(Long id);

    Complaint updateComplaintStatus(Long id, Complaint.Status status);
}