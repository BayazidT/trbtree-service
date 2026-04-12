package com.trbtree.service.modules.protfolio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@Setter
@Getter
public class EducationResponse {
    private UUID id;
    private String degree;
    private String institution;
    private String fieldOfStudy;
    private String description;
    private boolean isCurrent;
    private LocalDate startDate;
    private LocalDate endDate;
    private short startYear;
    private short endYear;
    private short displayOrder;
}
