package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.CertificationRequest;
import com.trbtree.service.modules.protfolio.dto.CertificationResponse;
import com.trbtree.service.modules.protfolio.entity.Certification;
import com.trbtree.service.modules.protfolio.mapper.CertificationMapper;
import com.trbtree.service.modules.protfolio.repository.CertificationRepository;
import com.trbtree.service.modules.protfolio.service.CertificationService;
import io.jsonwebtoken.lang.Collections;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class CertificationServiceImpl implements CertificationService {
    private final CertificationRepository certificationRepository;
    private final CertificationMapper certificationMapper;

    @Override
    public List<CertificationResponse> getCertifications(UUID userId) {
        return Optional.ofNullable(certificationRepository.findByUserId(userId))
                .orElse(Collections.emptyList())
                .stream()
                .map(certificationMapper::toDTO)
                .toList();
    }

    @Override
    public CertificationResponse addCertification(CertificationRequest request, UUID userId) {
        Certification certification = certificationMapper.toEntity(request);
        certification.setUserId(userId);
        return certificationMapper.toDTO(certificationRepository.save(certification));
    }
}
