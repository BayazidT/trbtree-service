package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ProjectRequest {
    private String title;
    private String projectUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isOngoing;
    private List<String> description;
    private List<String> technologies;
}