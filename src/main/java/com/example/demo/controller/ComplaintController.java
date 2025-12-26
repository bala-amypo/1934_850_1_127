package com.example.demo.controller;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {
    private final ComplaintService complaintService;
    private final UserService userService;

    public ComplaintController(ComplaintService complaintService, UserService userService) {
        this.complaintService = complaintService;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public ResponseEntity<Complaint> submitComplaint(@RequestBody ComplaintRequest request, @RequestParam String email) {
        // Find user from email (typically extracted from JWT in production) [cite: 95]
        User customer = userService.findByEmail(email);
        Complaint complaint = complaintService.submitComplaint(request, customer);
        return ResponseEntity.ok(complaint);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Complaint>> getUserComplaints(@PathVariable Long userId) {
        // In a real scenario, you'd fetch the User entity by ID first [cite: 96]
        User user = new User();
        user.setId(userId);
        return ResponseEntity.ok(complaintService.getComplaintsForUser(user));
    }

    @GetMapping("/prioritized")
    public ResponseEntity<List<Complaint>> getPrioritized() {
        // Returns complaints sorted by HQL logic: Score DESC, Date ASC [cite: 97, 48]
        return ResponseEntity.ok(complaintService.getPrioritizedComplaints());
    }
}