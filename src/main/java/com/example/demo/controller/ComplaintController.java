package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/submit")
    public ComplaintResponse submitComplaint(@RequestBody ComplaintRequest request) {
        // Dummy user for now
        User customer = new User();
        customer.setEmail("dummy@example.com");

        Complaint complaint = complaintService.submitComplaint(request, customer);

        ComplaintResponse response = new ComplaintResponse();
        response.setId(complaint.getId());
        response.setTitle(complaint.getTitle());
        response.setStatus(complaint.getStatus().name());
        response.setPriorityScore(complaint.getPriorityScore());
        return response;
    }

    @GetMapping("/all")
    public List<ComplaintResponse> getAllComplaints() {
        List<Complaint> complaints = complaintService.getPrioritizedComplaints();
        return complaints.stream().map(c -> {
            ComplaintResponse r = new ComplaintResponse();
            r.setId(c.getId());
            r.setTitle(c.getTitle());
            r.setStatus(c.getStatus().name());
            r.setPriorityScore(c.getPriorityScore());
            return r;
        }).collect(Collectors.toList());
    }
}
