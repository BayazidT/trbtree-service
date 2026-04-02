package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.EducationRequest;
import com.trbtree.service.modules.protfolio.dto.EducationResponse;
import com.trbtree.service.modules.protfolio.dto.ProfileRequest;
import com.trbtree.service.modules.protfolio.dto.ProfileResponse;
import com.trbtree.service.modules.protfolio.entity.Education;
import com.trbtree.service.modules.protfolio.entity.UserProfile;
import com.trbtree.service.modules.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class EducationMapper {

    private EducationMapper() {
        // prevent instantiation
    }
    public static Education toEntity(EducationRequest educationRequest, User user) {
        Education education = new Education();
        education.setUser(user);
        education.setDescription(educationRequest.getDescription());
        education.setInstitution(educationRequest.getInstitution());
        education.setDegree(educationRequest.getDegree());
        education.setFieldOfStudy(educationRequest.getFieldOfStudy());
        education.setDescription(educationRequest.getDescription());
        education.setCurrent(educationRequest.isCurrent());
        education.setDisplayOrder(educationRequest.getDisplayOrder());
        education.setStartDate(educationRequest.getStartDate());
        education.setEndDate(educationRequest.getEndDate());
        education.setStartYear(educationRequest.getStartYear());
        education.setEndYear(educationRequest.getEndYear());
        return education;
    }

    public  EducationResponse toResponse(Education entity) {
        if (entity == null) {
            return null;
        }

        return EducationResponse.builder()
                .endYear(entity.getEndYear())
                .startYear(entity.getStartYear())
                .endDate(entity.getEndDate())
                .description(entity.getDescription())
                .degree(entity.getDegree())
                .displayOrder(entity.getDisplayOrder())
                .startDate(entity.getStartDate())
                .fieldOfStudy(entity.getFieldOfStudy())
                .institution(entity.getInstitution())
                .isCurrent(entity.isCurrent())
                .build();
    }

    public Education updateEducation(Education education, EducationRequest request) {
        return education;
    }
}