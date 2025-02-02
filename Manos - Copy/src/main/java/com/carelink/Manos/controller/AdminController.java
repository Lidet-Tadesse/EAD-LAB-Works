package com.carelink.Manos.controller;

import com.carelink.Manos.model.Donor;
import com.carelink.Manos.model.Recipient;
import com.carelink.Manos.repository.DonorRepository;
import com.carelink.Manos.repository.RecipientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    // Serve the admin page (HTML file)
    @GetMapping("/admin")
    public String showAdminDashboardPage() {
        return "admin-dashboard"; // Refers to src/main/resources/templates/admin-dashboard.html
    }

    // API endpoint to fetch donors and recipients in JSON format
    @GetMapping("/admin/data")
    @ResponseBody
    public AdminDashboardData showAdminDashboardData() {
        List<Donor> donors = donorRepository.findAll(); // Fetch all donors
        List<Recipient> recipients = recipientRepository.findAll(); // Fetch all recipients

        return new AdminDashboardData(donors, recipients);
    }

    // DTO class to return both donors and recipients
    public static class AdminDashboardData {
        private List<Donor> donors;
        private List<Recipient> recipients;

        public AdminDashboardData(List<Donor> donors, List<Recipient> recipients) {
            this.donors = donors;
            this.recipients = recipients;
        }

        public List<Donor> getDonors() {
            return donors;
        }

        public List<Recipient> getRecipients() {
            return recipients;
        }
    }
}
