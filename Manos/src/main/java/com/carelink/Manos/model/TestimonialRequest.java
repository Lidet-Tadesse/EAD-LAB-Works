package com.carelink.Manos.model;

public class TestimonialRequest {

    private String title;
    private String description;

    // Constructors, getters, and setters
    public TestimonialRequest() {
    }

    public TestimonialRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
