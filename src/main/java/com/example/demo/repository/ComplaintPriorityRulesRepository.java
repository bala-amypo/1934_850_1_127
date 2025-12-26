package com.example.demo.repository;

import com.example.demo.entity.ComplaintPriorityRules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ComplaintPriorityRulesRepository extends JpaRepository<ComplaintPriorityRules, Long> {
    
    Optional<ComplaintPriorityRules> findByCategoryIgnoreCase(String category);
    
}