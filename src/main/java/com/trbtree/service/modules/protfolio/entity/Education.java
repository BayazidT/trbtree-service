package com.trbtree.service.modules.protfolio.entity;

import com.trbtree.service.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

// Education
@Entity
@Table(name = "profile_educations", schema = "trbtree")
@Getter
@Setter
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String degree;
    private String institution;

    @Column(name = "field_of_study")
    private String fieldOfStudy;

    private String description;


    @Column(name = "is_current")
    private boolean isCurrent = false;

    @Column(name = "start_year")
    private short startYear;

    @Column(name = "end_year")
    private short endYear;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "display_order")
    private short displayOrder;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

}