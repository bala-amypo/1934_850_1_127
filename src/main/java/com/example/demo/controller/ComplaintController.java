package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // Create a new complaint
    @PostMapping
    public ComplaintResponse createComplaint(@RequestBody ComplaintRequest request) {
        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());
        complaint.setPriorityScore(request.getPriorityScore());
        complaint.setStatus(request.getStatus());
        complaint.setSeverity(request.getSeverity());
        complaint.setUrgency(request.getUrgency());

        Complaint saved = complaintService.saveComplaint(complaint);

        return mapToResponse(saved);
    }

    // Get all complaints
    @GetMapping
    public List<ComplaintResponse> getAllComplaints() {
        List<Complaint> complaints = complaintService.getAllComplaints();
        return complaints.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // Get complaint by id
    @GetMapping("/{id}")
    public ComplaintResponse getComplaintById(@PathVariable Long id) {
        Complaint complaint = complaintService.getComplaintById(id);
        return mapToResponse(complaint);
    }

    // Update complaint
    @PutMapping("/{id}")
    public ComplaintResponse updateComplaint(@PathVariable Long id, @RequestBody ComplaintRequest request) {
        Complaint complaint = complaintService.getComplaintById(id);

        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());
        complaint.setPriorityScore(request.getPriorityScore());
        complaint.setStatus(request.getStatus());
        complaint.setSeverity(request.getSeverity());
        complaint.setUrgency(request.getUrgency());

        Complaint updated = complaintService.saveComplaint(complaint);
        return mapToResponse(updated);
    }

    // Delete complaint
    @DeleteMapping("/{id}")
    public void deleteComplaint(@PathVariable Long id) {
        complaintService.deleteComplaint(id);
    }

    // ===== Helper method to map entity to DTO =====
    private ComplaintResponse mapToResponse(Complaint complaint) {
        ComplaintResponse response = new ComplaintResponse();
        response.setId(complaint.getId());
        response.setTitle(complaint.getTitle());
        response.setDescription(complaint.getDescription());
        response.setCategory(complaint.getCategory());
        response.setChannel(complaint.getChannel());
        response.setPriorityScore(complaint.getPriorityScore());
        response.setCreatedAt(complaint.getCreatedAt());
        response.setStatus(complaint.getStatus());
        response.setSeverity(complaint.getSeverity());
        response.setUrgency(complaint.getUrgency());
        return response;
    }
}
