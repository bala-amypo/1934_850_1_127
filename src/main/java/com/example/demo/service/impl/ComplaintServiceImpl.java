package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.service.ComplaintService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;

    public ComplaintServiceImpl(ComplaintRepository complaintRepository) {
        this.complaintRepository = complaintRepository;
    }

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @Override
    public List<Complaint> getComplaintsByPriorityScore(Integer priorityScore) {
        return complaintRepository.findByPriorityScore(priorityScore);
    }

    @Override
    public List<Complaint> getComplaintsBySeverity(Complaint.Severity severity) {
        return complaintRepository.findBySeverity(severity);
    }

    @Override
    public List<Complaint> getComplaintsByUrgency(Complaint.Urgency urgency) {
        return complaintRepository.findByUrgency(urgency);
    }
}
