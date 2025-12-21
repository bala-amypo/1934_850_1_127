package com.example.demo.service;

import com.example.demo.dto.ComplaintRequest;
import com.example.demo.dto.ComplaintResponse;
import java.util.List;

public interface ComplaintService {

    ComplaintResponse submitComplaint(ComplaintRequest request);

    List<ComplaintResponse> getPrioritizedComplaints();
}
