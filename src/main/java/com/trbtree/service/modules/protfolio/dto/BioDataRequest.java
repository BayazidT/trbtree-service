package com.trbtree.service.modules.protfolio.dto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class BioDataRequest {

    private String gender;
    private LocalDate dateOfBirth;
    private String height;
    private String placeOfBirth;
    private Short weight;

    private String bloodGroup;
    private String maritalStatus;

    // ========================
    // Location
    // ========================
    private String presentAddress;
    private String permanentAddress;
    private String city;
    private String state;
    private String country;

    private String religion;

    private String highestEducation;
    private String fieldOfStudy;
    private String occupation;
    private String companyName;
    private Integer annualIncome;
    private String currency;

    private String fatherOccupation;
    private String fatherName;
    private String motherOccupation;
    private String motherName;
    private Short siblingsCount;
    private String familyType;
    private String familyDetails;
    private String familyStatus;

    private String diet;
    private Boolean smoking;
    private Boolean drinking;

    private String aboutMe;
    private String partnerExpectation;
    private String preferred_age;
    private String preferred_education ;
    private String preferred_profession;
    private String preferred_location;
    private Boolean shift_abroad;

    private String profilePictureUrl;
    private List<String> galleryUrls;

    private Boolean isPublic;
    private Boolean showContact;
}