package com.trbtree.service.modules.protfolio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Setter
@Getter
public class EducationRequest {
    private String degree;              // from User
    private String institution;           // from User
    private String fieldOfStudy;                 // from UserProfile
    private String description;                 // from UserProfile
    private boolean isCurrent;
    private LocalDate startDate;
    private LocalDate endDate;
    private short startYear;
    private short endYear;
    private short displayOrder;
}
