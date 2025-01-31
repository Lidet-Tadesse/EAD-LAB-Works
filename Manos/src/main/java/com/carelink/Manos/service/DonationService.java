package com.carelink.Manos.service;

import com.carelink.Manos.model.Donation;
import com.carelink.Manos.repository.DonationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {
    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll(); // Fetch all donations
    }
}
