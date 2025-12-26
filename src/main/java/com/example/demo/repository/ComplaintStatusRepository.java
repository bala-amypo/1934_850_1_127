package com.example.demo.repository;

import com.example.demo.entity.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatus, Long> {
    // Typical CRUD operations for status history [cite: 411]
}