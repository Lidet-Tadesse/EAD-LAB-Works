package com.carelink.Manos.controller;

import com.carelink.Manos.model.Testimonial;
import com.carelink.Manos.model.TestimonialRequest;
import com.carelink.Manos.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    // Endpoint to create a new testimonial
    @PostMapping
    public ResponseEntity<Testimonial> createTestimonial(@RequestBody TestimonialRequest request) {
        Testimonial testimonial = testimonialService.createTestimonial(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonial);
    }

    // Endpoint to get all testimonials
    @GetMapping
    public ResponseEntity<List<Testimonial>> getAllTestimonials() {
        List<Testimonial> testimonials = testimonialService.getAllTestimonials();
        return ResponseEntity.ok(testimonials);
    }
}
