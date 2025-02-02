package com.carelink.Manos.service;

import com.carelink.Manos.repository.DonorHistoryRepository;
import com.carelink.Manos.repository.DonorRepository;
import com.carelink.Manos.model.DonorHistory;
import com.carelink.Manos.model.Donor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DonorHistoryService {

    @Autowired
    private DonorHistoryRepository donorHistoryRepository;

    @Autowired
    private DonorRepository donorRepository;

    public void addDonationHistory(Long donorId, BigDecimal amount, String method, String message) {
        Donor donor = donorRepository.findById(donorId).orElseThrow(() -> new RuntimeException("Donor not found"));

        DonorHistory donorHistory = new DonorHistory();
        donorHistory.setDonor(donor);
        donorHistory.setAmount(amount);
        donorHistory.setDonationMethod(method);
        donorHistory.setDonationMessage(message);

        donorHistoryRepository.save(donorHistory);
    }

    public List<DonorHistory> getDonorHistory(Long donorId) {
        Donor donor = donorRepository.findById(donorId).orElseThrow(() -> new RuntimeException("Donor not found"));
        return donorHistoryRepository.findByDonor(donor);
    }
}
