package com.carelink.Manos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recipient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String requestedItem;
    private String urgencyLevel;
    private String category;
    private String gender;
    private String ageGroup;
    private Integer familyMembers;
    private String donationMode;
    private String proofDocuments; // Could be a file path or reference to a storage location
    private String locationCoordinates;
    private String languagePreference;
    private String status;
    private String specificRequest; // Detailed description

    @OneToMany(mappedBy = "recipient")
    private List<DonationRequest> donationRequests;

    // No-argument constructor (needed for JPA)
    public Recipient() {
    }

    // Constructor with parameters
    public Recipient(String name, String email, String phoneNumber, String address, String requestedItem,
            String urgencyLevel, String category, String gender, String ageGroup, Integer familyMembers,
            String donationMode, String proofDocuments, String locationCoordinates,
            String languagePreference, String status, String specificRequest) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.requestedItem = requestedItem;
        this.urgencyLevel = urgencyLevel;
        this.category = category;
        this.gender = gender;
        this.ageGroup = ageGroup;
        this.familyMembers = familyMembers;
        this.donationMode = donationMode;
        this.proofDocuments = proofDocuments;
        this.locationCoordinates = locationCoordinates;
        this.languagePreference = languagePreference;
        this.status = status;
        this.specificRequest = specificRequest;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequestedItem() {
        return requestedItem;
    }

    public void setRequestedItem(String requestedItem) {
        this.requestedItem = requestedItem;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Integer getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(Integer familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getDonationMode() {
        return donationMode;
    }

    public void setDonationMode(String donationMode) {
        this.donationMode = donationMode;
    }

    public String getProofDocuments() {
        return proofDocuments;
    }

    public void setProofDocuments(String proofDocuments) {
        this.proofDocuments = proofDocuments;
    }

    public String getLocationCoordinates() {
        return locationCoordinates;
    }

    public void setLocationCoordinates(String locationCoordinates) {
        this.locationCoordinates = locationCoordinates;
    }

    public String getLanguagePreference() {
        return languagePreference;
    }

    public void setLanguagePreference(String languagePreference) {
        this.languagePreference = languagePreference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecificRequest() {
        return specificRequest;
    }

    public void setSpecificRequest(String specificRequest) {
        this.specificRequest = specificRequest;
    }

    public List<DonationRequest> getDonationRequests() {
        return donationRequests;
    }

    public void setDonationRequests(List<DonationRequest> donationRequests) {
        this.donationRequests = donationRequests;
    }
}
