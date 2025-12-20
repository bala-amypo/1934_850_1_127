package com.example.demo.service;

import com.example.demo.entity.Complaint;
import java.util.List;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);
    List<Complaint> getAllComplaints();
    Complaint getComplaintById(Long id);
    void deleteComplaint(Long id);
}
