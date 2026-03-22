package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.EducationRequest;
import com.trbtree.service.modules.protfolio.dto.EducationResponse;
import com.trbtree.service.modules.protfolio.dto.ProfileRequest;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.entity.Education;
import com.trbtree.service.modules.protfolio.entity.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {

    private EducationMapper() {
        // prevent instantiation
    }

    public static EducationResponse toResponse(Education entity) {
        if (entity == null) {
            return null;
        }

        return EducationResponse.builder()
                .userId(entity.getUserId())
                .build();
    }

    public Education updateEudcation(Education education, EducationRequest request) {

        return education;
    }
}