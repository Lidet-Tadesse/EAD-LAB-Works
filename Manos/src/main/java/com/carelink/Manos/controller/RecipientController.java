package com.carelink.Manos.controller;

import com.carelink.Manos.model.Recipient;
import com.carelink.Manos.repository.RecipientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RecipientController {

    private final RecipientRepository recipientRepository;

    public RecipientController(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    // Show the recipient creation form
    @GetMapping("/recipients/create")
    public String showCreateForm(Model model) {
        model.addAttribute("recipient", new Recipient()); // Add an empty Recipient object
        return "recipient-form"; // Return the Thymeleaf template for the form
    }

    // Handle recipient form submission and save recipient to the database
    @PostMapping("/recipients/create")
    public String createRecipient(@ModelAttribute Recipient recipient, Model model) {
        // Save recipient to the database
        recipientRepository.save(recipient);

        // Add success message to the model
        model.addAttribute("message", "Recipient created successfully!");

        // Redirect to a success page (or the same form with a success message)
        return "redirect:/recipients/create"; // Or another success template
    }
}
