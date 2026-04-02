package com.trbtree.service.modules.protfolio.entity;

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
@Table(name = "profile_experiences")
@Getter
@Setter
public class Experience {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    private String jobTitle;
    private String companyName;
    private String companyUrl;
    private String location;

    private LocalDate startDate;
    private LocalDate endDate;

    private Boolean isCurrent = false;
    private String durationText;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<String> responsibilities;

    private Short displayOrder;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}