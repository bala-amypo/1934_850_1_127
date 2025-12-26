package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {
    private final PriorityRuleRepository priorityRuleRepository;

    public PriorityRuleServiceImpl(PriorityRuleRepository priorityRuleRepository) {
        this.priorityRuleRepository = priorityRuleRepository;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;

        // 1. Sum weights of all active rules
        List<PriorityRule> activeRules = priorityRuleRepository.findByActiveTrue();
        for (PriorityRule rule : activeRules) {
            score += rule.getWeight();
        }

        // 2. Add points for Severity (Low=10, Med=20, High=30, Critical=40)
        if (complaint.getSeverity() != null) {
            score += (complaint.getSeverity().ordinal() + 1) * 10;
        }

        // 3. Add points for Urgency (Low=5, Med=10, High=15, Immediate=20)
        if (complaint.getUrgency() != null) {
            score += (complaint.getUrgency().ordinal() + 1) * 5;
        }

        return score;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return priorityRuleRepository.findByActiveTrue();
    }
}