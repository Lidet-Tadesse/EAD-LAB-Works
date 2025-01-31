package com.carelink.Manos.service;

import com.carelink.Manos.model.Donor;
import com.carelink.Manos.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }
}
