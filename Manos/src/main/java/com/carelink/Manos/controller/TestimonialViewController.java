package com.carelink.Manos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestimonialViewController {

    @GetMapping("/testimonials")
    public String showTestimonialsPage() {
        return "testimonials"; // Ensure you have templates/testimonials.html
    }
}
