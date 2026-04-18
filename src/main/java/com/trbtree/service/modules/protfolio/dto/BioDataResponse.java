package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class BioDataResponse {

    private UUID userId;

    private String gender;
    private LocalDate dateOfBirth;

    private Short heightCm;
    private Short weightKg;

    private String bloodGroup;
    private String maritalStatus;

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
    private String motherOccupation;
    private Short siblingsCount;
    private String familyType;
    private String familyStatus;

    private String diet;
    private Boolean smoking;
    private Boolean drinking;

    private String aboutMe;
    private String partnerExpectation;

    private String profilePictureUrl;
    private List<String> galleryUrls;


    private Boolean isPublic;
    private Boolean showContact;
}