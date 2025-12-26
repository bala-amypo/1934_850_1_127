package com.example.demo.service;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.PriorityRule;
import java.util.List;

public interface PriorityRuleService {
    // Core engine logic: calculates score based on severity, urgency, and rules
    int computePriorityScore(Complaint complaint);
    
    // Retrieves enabled rules for management or scoring
    List<PriorityRule> getActiveRules();
}