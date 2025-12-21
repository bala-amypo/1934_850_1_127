package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.service.ComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    private final ComplaintService complaintService;

    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }

    @PostMapping("/submit")
    public ResponseEntity<ComplaintResponse> submit(@Valid @RequestBody ComplaintRequest request) {
        ComplaintResponse response = complaintService.submitComplaint(request);

        // If message exists, return 200 OK
        if (response.getMessage() != null) {
            return ResponseEntity.ok(response);
        }

        // Otherwise, complaint was saved successfully
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Optional: Get all prioritized complaints
    @GetMapping("/prioritized")
    public ResponseEntity<?> getPrioritizedComplaints() {
        return ResponseEntity.ok(complaintService.getPrioritizedComplaints());
    }
}
