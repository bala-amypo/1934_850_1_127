package com.example.demo.controller;

import com.example.demo.entity.PriorityRule;
import com.example.demo.repository.PriorityRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/priority-rules")
public class PriorityRuleController {

    @Autowired
    private PriorityRuleRepository priorityRuleRepository;

    @PostMapping("/add")
    public ResponseEntity<?> addPriorityRule(@RequestBody PriorityRule priorityRule) {

        // check duplicate rule name
        if (priorityRuleRepository.findByRuleName(priorityRule.getRuleName()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Rule name already exists!");
        }

        PriorityRule savedRule = priorityRuleRepository.save(priorityRule);
        return ResponseEntity.ok(savedRule);
    }
}
