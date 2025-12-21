package com.example.demo.service.impl;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import com.example.demo.service.PriorityRuleService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PriorityRuleServiceImpl implements PriorityRuleService {

    private final PriorityRuleRepository repo;

    public PriorityRuleServiceImpl(PriorityRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public int computePriorityScore(Complaint complaint) {
        int score = 0;

        if (complaint.getSeverity() != null) {
            switch (complaint.getSeverity()) {
                case CRITICAL -> score += 40;
                case HIGH -> score += 30;
                case MEDIUM -> score += 20;
                case LOW -> score += 10;
            }
        }

        if (complaint.getUrgency() != null) {
            switch (complaint.getUrgency()) {
                case IMMEDIATE -> score += 40;
                case HIGH -> score += 30;
                case MEDIUM -> score += 20;
                case LOW -> score += 10;
            }
        }

        for (PriorityRule rule : repo.findByActiveTrue()) {
            score += rule.getWeight();
        }

        return score;
    }

    @Override
    public List<PriorityRule> getActiveRules() {
        return repo.findByActiveTrue();
    }
}
