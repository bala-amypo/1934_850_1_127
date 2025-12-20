package com.example.demo.service;

import com.example.demo.entity.PriorityRule;
import com.example.demo.entity.Complaint;

import java.util.List;

public interface PriorityRuleService {
    int computePriorityScore(Complaint complaint);
    List<PriorityRule> getActiveRules();
}
