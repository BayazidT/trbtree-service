package com.trbtree.service.modules.protfolio.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PublicationRequest {
    private String title;
    private LocalDate publicationDate;
    private String publisher;
    private String url;
    private String description;
}