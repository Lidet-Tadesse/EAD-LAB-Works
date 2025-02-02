package com.carelink.Manos.service;

import com.carelink.Manos.model.Testimonial;
import com.carelink.Manos.model.TestimonialRequest;
import com.carelink.Manos.repository.TestimonialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    // Method to create a testimonial
    public Testimonial createTestimonial(TestimonialRequest request) {
        Testimonial testimonial = new Testimonial();
        testimonial.setTitle(request.getTitle());
        testimonial.setDescription(request.getDescription());
        return testimonialRepository.save(testimonial);
    }

    // Method to get all testimonials
    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }
}
