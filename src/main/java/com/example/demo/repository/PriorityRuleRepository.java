package com.example.demo.repository;

import com.example.demo.entity.PriorityRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PriorityRuleRepository extends JpaRepository<PriorityRule, Long> {
    
    List<PriorityRule> findByActiveTrue();

    // ADD THIS: To look up specific weights for the prioritization math
    Optional<PriorityRule> findByTypeIgnoreCase(String type);
    Optional<PriorityRule> findByLevelIgnoreCase(String level);
}