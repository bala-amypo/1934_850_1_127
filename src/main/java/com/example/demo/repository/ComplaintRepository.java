package com.example.demo.repository;

import com.example.demo.entity.Complaint;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    
    // Retrieves all complaints for a specific customer [cite: 405, 439]
    List<Complaint> findByCustomer(User customer);

    // Advanced HQL query for prioritized engine sorting [cite: 406, 346, 358]
    @Query("SELECT c FROM Complaint c ORDER BY c.priorityScore DESC, c.createdAt ASC")
    List<Complaint> findAllOrderByPriorityScoreDescCreatedAtAsc();
}