package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.EducationRequest;
import com.trbtree.service.modules.protfolio.dto.EducationResponse;
import com.trbtree.service.modules.protfolio.entity.Education;
import com.trbtree.service.modules.protfolio.mapper.EducationMapper;
import com.trbtree.service.modules.protfolio.repository.EducationRepository;
import com.trbtree.service.modules.protfolio.service.EducationService;
import com.trbtree.service.modules.user.entity.User;
import com.trbtree.service.modules.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;
    private final UserRepository userRepository;
    private final EducationMapper educationMapper;

    @Override
    public List<EducationResponse> getEducationByUserId(UUID userId) {
        return Optional.ofNullable(educationRepository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(educationMapper::toResponse)
                .toList();
    }

    @Override
    public EducationResponse updateEducation(EducationRequest educationRequest, UUID id) {
        Education oldEntry = educationRepository.findById(id).orElse(null);
        Education newEntry = educationMapper.toEntity(educationRequest, oldEntry.getUser());
        educationRepository.delete(oldEntry);
        return educationMapper.toResponse(educationRepository.save(newEntry));
    }

    @Override
    public EducationResponse createEducation(EducationRequest educationRequest, UUID userId) {
        User user =  userRepository.findById(userId).orElseThrow();
        return educationMapper.toResponse(educationRepository.save(educationMapper.toEntity(educationRequest, user)));
    }
}
