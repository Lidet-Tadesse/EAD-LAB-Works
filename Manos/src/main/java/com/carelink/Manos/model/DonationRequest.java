package com.carelink.Manos.model;

import jakarta.persistence.*;

@Entity
public class DonationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String status; // E.g., Pending, Fulfilled
    private String category; // E.g., food, financial aid

    @ManyToOne
    private Recipient recipient;

    // Getters and Setters
}
