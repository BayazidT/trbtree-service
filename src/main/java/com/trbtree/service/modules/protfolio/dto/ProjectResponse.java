package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ProjectResponse {
    private UUID id;
    private String title;
    private String projectUrl;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isOngoing;
    private List<String> description;
    private List<String> technologies;
}