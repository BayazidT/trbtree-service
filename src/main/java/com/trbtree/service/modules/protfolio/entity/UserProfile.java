package com.trbtree.service.modules.protfolio.entity;

import com.trbtree.service.modules.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

// UserProfile.java (main profile header)
@Entity
@Table(name = "user_profiles", schema = "trbtree")
@Getter
@Setter
@NoArgsConstructor
public class UserProfile {

    @Id
    @Column(name = "user_id")
    private UUID userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private String headline;
    private String currentDesignation;
    private String profilePictureUrl;
    private String introduction;
    private boolean openToWork;

    private String email;
    private String phone;
    private String linkedinUrl;
    private String githubUrl;

    private boolean isPublic = false;

    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt = LocalDateTime.now();

    // getters, setters, builder...
}