package com.example.demo.service.impl;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.User;
import com.example.demo.repository.ComplaintRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.ComplaintService;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepo;
    private final PriorityRuleService priorityRuleService;
    private final UserRepository userRepo;

    public ComplaintServiceImpl(
            ComplaintRepository complaintRepo,
            PriorityRuleService priorityRuleService,
            UserRepository userRepo) {
        this.complaintRepo = complaintRepo;
        this.priorityRuleService = priorityRuleService;
        this.userRepo = userRepo;
    }

    @Override
    public ComplaintResponse submitComplaint(ComplaintRequest request) {

        // 1️⃣ Load customer safely
        Optional<User> customerOpt = userRepo.findById(request.getCustomerId());
        if (customerOpt.isEmpty()) {
            return ComplaintResponse.withMessage(
                    "Customer not found with id: " + request.getCustomerId()
            );
        }
        User customer = customerOpt.get();

        // 2️⃣ Map request → entity
        Complaint complaint = new Complaint();
        complaint.setTitle(request.getTitle());
        complaint.setDescription(request.getDescription());
        complaint.setCategory(request.getCategory());
        complaint.setChannel(request.getChannel());
        complaint.setCustomer(customer);

        // 3️⃣ Convert enums safely
        try {
            complaint.setSeverity(Complaint.Severity.valueOf(request.getSeverity().toUpperCase()));
            complaint.setUrgency(Complaint.Urgency.valueOf(request.getUrgency().toUpperCase()));
        } catch (IllegalArgumentException e) {
            return ComplaintResponse.withMessage("Invalid severity or urgency value");
        }

        // 4️⃣ Attach active priority rules
        List<PriorityRule> activeRules = priorityRuleService.getActiveRules();
        complaint.setPriorityRules(activeRules);

        // 5️⃣ Compute priority score
        complaint.setPriorityScore(priorityRuleService.computePriorityScore(complaint));

        // 6️⃣ Save complaint
        Complaint saved = complaintRepo.save(complaint);

        // 7️⃣ Return response
        return new ComplaintResponse(saved);
    }

    @Override
    public List<ComplaintResponse> getPrioritizedComplaints() {
        return complaintRepo.findAllOrdered()
                .stream()
                .map(ComplaintResponse::new)
                .toList();
    }
}
