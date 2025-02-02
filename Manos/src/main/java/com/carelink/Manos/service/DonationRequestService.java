package com.carelink.Manos.service;

import com.carelink.Manos.model.DonationRequest;
import com.carelink.Manos.repository.DonationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationRequestService {
    @Autowired
    private DonationRequestRepository donationRequestRepository;

    public DonationRequest createDonationRequest(DonationRequest request) {
        return donationRequestRepository.save(request);
    }

    public DonationRequest getDonationRequest(Long id) {
        return donationRequestRepository.findById(id).orElse(null);
    }
}
