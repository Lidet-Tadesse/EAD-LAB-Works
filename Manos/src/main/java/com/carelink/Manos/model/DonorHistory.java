package com.carelink.Manos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "donor_history")
public class DonorHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "donor_id")
    private Donor donor;

    private BigDecimal amount;
    private String donationMethod;
    private String donationMessage;

    @Column(name = "donation_date")
    private LocalDateTime donationDate;

    // Default constructor
    public DonorHistory() {
    }

    // Getter and Setter methods

    // Getters
    public Long getId() {
        return id;
    }

    public Donor getDonor() {
        return donor;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDonationMethod() {
        return donationMethod;
    }

    public String getDonationMessage() {
        return donationMessage;
    }

    public LocalDateTime getDonationDate() {
        return donationDate;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDonationMethod(String donationMethod) {
        this.donationMethod = donationMethod;
    }

    public void setDonationMessage(String donationMessage) {
        this.donationMessage = donationMessage;
    }

    public void setDonationDate(LocalDateTime donationDate) {
        this.donationDate = donationDate;
    }

    // PrePersist method to set donationDate to current time if not provided
    @PrePersist
    public void prePersist() {
        if (donationDate == null) {
            donationDate = LocalDateTime.now();
        }
    }
}
