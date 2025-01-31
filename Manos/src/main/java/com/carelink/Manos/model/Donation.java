package com.carelink.Manos.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private String category;
    private String type; // E.g., money, goods
    private Boolean isAnonymous;

    @ManyToOne
    private Donor donor;

    @ManyToOne
    private Recipient recipient;

    // Getters and Setters
}
