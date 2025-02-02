package com.carelink.Manos.repository;

import com.carelink.Manos.model.DonationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRequestRepository extends JpaRepository<DonationRequest, Long> {
}
