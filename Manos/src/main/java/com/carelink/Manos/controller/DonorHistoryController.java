package com.carelink.Manos.controller;

import com.carelink.Manos.model.Donor;
import com.carelink.Manos.model.DonorHistory;
import com.carelink.Manos.service.DonorHistoryService;
import com.carelink.Manos.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class DonorHistoryController {

    @Autowired
    private DonorHistoryService donorHistoryService;

    @Autowired
    private DonorService donorService;

    // Get Donor History by Donor ID
    @GetMapping("/donors/{donorId}/donations")
    public String getDonorHistory(@PathVariable Long donorId, Model model) {
        // Fetch the donor details
        Donor donor = donorService.getDonorById(donorId);

        // Fetch the donation history for the given donor
        List<DonorHistory> donorHistory = donorHistoryService.getDonorHistory(donorId);

        // Add the donor and donor history to the model
        model.addAttribute("donor", donor);
        model.addAttribute("donorHistory", donorHistory);

        // Return the view name (Thymeleaf template)
        return "donor-history";
    }
}
