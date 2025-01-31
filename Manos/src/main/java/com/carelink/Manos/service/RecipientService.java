package com.carelink.Manos.service;

import com.carelink.Manos.model.Recipient;
import com.carelink.Manos.repository.RecipientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipientService {

    private final RecipientRepository recipientRepository;

    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    // Method to fetch all recipients
    public List<Recipient> getAllRecipients() {
        return recipientRepository.findAll();
    }

    // Method to save a recipient
    public void saveRecipient(Recipient recipient) {
        recipientRepository.save(recipient); // Save recipient to database
    }
}
