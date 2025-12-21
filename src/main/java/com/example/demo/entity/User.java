package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    /* =======================
       RELATIONSHIPS
       ======================= */

    @OneToMany(mappedBy = "customer")
    private List<Complaint> complaints = new ArrayList<>();

    @OneToMany(mappedBy = "assignedAgent")
    private List<Complaint> assignedComplaints = new ArrayList<>();

    /* =======================
       ENUM
       ======================= */

    public enum Role {
        CUSTOMER, AGENT, ADMIN
    }

    /* =======================
       GETTERS & SETTERS
       ======================= */

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Complaint> getComplaints() {
        return complaints;
    }

    public List<Complaint> getAssignedComplaints() {
        return assignedComplaints;
    }
}
