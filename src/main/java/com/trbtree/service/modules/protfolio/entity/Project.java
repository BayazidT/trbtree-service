package com.trbtree.service.modules.protfolio.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "profile_projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID userId;

    private String title;
    private String projectUrl;

    private LocalDate startDate;
    private LocalDate endDate;

    private Boolean isOngoing = false;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> description;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> technologies;

    private Short displayOrder;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}