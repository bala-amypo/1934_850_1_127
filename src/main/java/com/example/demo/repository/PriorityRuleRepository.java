package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {

    // Find all active priority rules
    List<PriorityRule> findByActiveTrue();

    // Optional: find by category if needed
    // PriorityRule findByCategory(String category);
}
