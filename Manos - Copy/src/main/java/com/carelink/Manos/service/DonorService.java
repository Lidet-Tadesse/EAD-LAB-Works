package com.carelink.Manos.service;

import com.carelink.Manos.model.Donor;
import com.carelink.Manos.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    // Method to get a donor by ID
    public Donor getDonorById(Long donorId) {
        return donorRepository.findById(donorId).orElse(null);
    }
}
