package com.carelink.Manos.controller;

import com.carelink.Manos.model.Donor;
import com.carelink.Manos.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DonorController {

    @Autowired
    private DonorRepository donorRepository;

    // Show the donor creation form
    @GetMapping("/donors/create")
    public String showCreateForm(Model model) {
        model.addAttribute("donor", new Donor());
        return "donor-form"; // Return the donor form view
    }

    // Handle donor form submission via AJAX
    @PostMapping("/donors/create")
    @ResponseBody
    public String createDonor(@RequestParam String name,
            @RequestParam String email,
            @RequestParam Double amountDonated) {
        // Create a new Donor object
        Donor donor = new Donor();
        donor.setName(name);
        donor.setEmail(email);
        donor.setAmountDonated(amountDonated);

        // Save the donor to the database
        donorRepository.save(donor);

        // Return success message
        return "Donor registration successful!";
    }

    // Show the donor success page
    @GetMapping("/success")
    public String donorSuccess(Model model) {
        // You can add any additional data to the model if needed
        return "donorSuccess"; // Return the success page view
    }
}
