package com.trbtree.service.modules.protfolio.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Setter
@Getter
public class ProfileRequest {              // from User
    private String displayEmail;                 // from UserProfile
    private String displayPhone;                 // from UserProfile
    private String headline;              // from UserProfile
    private String currentDesignation;    // from UserProfile
    private String profilePictureUrl;     // from UserProfile
    private String introduction;          // from UserProfile
    private boolean openToWork;           // from UserProfile
    private String linkedinUrl;           // from UserProfile
    private String githubUrl;             // from UserProfile
    private boolean isPublic;             // from UserProfile
    private LocalDateTime lastUpdatedAt;
}
