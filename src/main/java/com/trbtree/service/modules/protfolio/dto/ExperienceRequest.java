package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ExperienceRequest {
    private String jobTitle;
    private String companyName;
    private String companyUrl;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isCurrent;
    private String durationText;
    private List<String> responsibilities;
}