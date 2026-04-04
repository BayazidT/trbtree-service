package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class PublicationResponse {
    private UUID id;
    private String title;
    private LocalDate publicationDate;
    private String publisher;
    private String url;
    private String description;
}