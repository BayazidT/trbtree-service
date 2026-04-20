package com.trbtree.service.modules.protfolio.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;
import com.vladmihalcea.hibernate.type.json.JsonType;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bio_data", schema = "trbtree")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BioData {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    // ========================
    // Basic Info
    // ========================
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

    // ========================
    // Religion & Culture
    // ========================
    private String religion;



    // ========================
    // Education & Career
    // ========================
    private String highestEducation;
    private String fieldOfStudy;
    private String occupation;
    private String companyName;
    private Integer annualIncome;
    private String currency;

    // ========================
    // Family
    // ========================
    private String fatherOccupation;
    private String fatherName;
    private String motherOccupation;
    private String motherName;
    private Short siblingsCount;
    private String familyType;
    private String familyDetails;
    private String familyStatus;

    // ========================
    // Lifestyle
    // ========================
    private String diet;
    private Boolean smoking;
    private Boolean drinking;

    // ========================
    // About
    // ========================
    @Column(columnDefinition = "TEXT")
    private String aboutMe;

    @Column(columnDefinition = "TEXT")
    private String partnerExpectation;

    private String preferred_age;
    private String preferred_education ;
    private String preferred_profession;
    private String preferred_location;
    private Boolean shift_abroad;

    // ========================
    // Media
    // ========================
    private String profilePictureUrl;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> galleryUrls;

    // ========================
    // Status
    // ========================

    private Boolean isPublic;
    private Boolean showContact;

    // ========================
    // Audit
    // ========================
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}