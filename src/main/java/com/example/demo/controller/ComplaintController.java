package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

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
        // TODO: set customer and assignedAgent from IDs

        Complaint saved = complaintService.saveComplaint(complaint);

        ComplaintResponse response = new ComplaintResponse();
        response.setId(saved.getId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setCategory(saved.getCategory());
        response.setChannel(saved.getChannel());
        response.setPriorityScore(saved.getPriorityScore());
        response.setCreatedAt(saved.getCreatedAt());
        response.setStatus(saved.getStatus());
        response.setSeverity(saved.getSeverity());
        response.setUrgency(saved.getUrgency());
        // TODO: set customerId and assignedAgentId

        return response;
    }

    @GetMapping
    public List<ComplaintResponse> getAllComplaints() {
        return complaintService.getAllComplaints().stream().map(c -> {
            ComplaintResponse r = new ComplaintResponse();
            r.setId(c.getId());
            r.setTitle(c.getTitle());
            r.setDescription(c.getDescription());
            r.setCategory(c.getCategory());
            r.setChannel(c.getChannel());
            r.setPriorityScore(c.getPriorityScore());
            r.setCreatedAt(c.getCreatedAt());
            r.setStatus(c.getStatus());
            r.setSeverity(c.getSeverity());
            r.setUrgency(c.getUrgency());
            // TODO: set customerId and assignedAgentId
            return r;
        }).collect(Collectors.toList());
    }
}
