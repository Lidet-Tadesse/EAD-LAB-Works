package com.carelink.Manos.repository;

import com.carelink.Manos.model.DonorHistory;
import com.carelink.Manos.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorHistoryRepository extends JpaRepository<DonorHistory, Long> {
    List<DonorHistory> findByDonor(Donor donor);
}
