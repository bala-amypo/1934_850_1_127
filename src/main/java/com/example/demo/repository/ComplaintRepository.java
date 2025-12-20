package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    // Get all complaints for a specific customer
    List<Complaint> findByCustomer(User customer);

    // Get all complaints ordered by priorityScore DESC and createdAt ASC
    @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.createdAt ASC")
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();

    // Optional: keep your existing methods
    List<Complaint> findByStatus(String status);
    List<Complaint> findByPriority(String priority);
}
