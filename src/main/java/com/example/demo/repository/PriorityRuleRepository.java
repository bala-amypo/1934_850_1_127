package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {
    
    // Fetches only rules where 'active' is true for score computation [cite: 409, 306]
    List<PriorityRule> findByActiveTrue();
}