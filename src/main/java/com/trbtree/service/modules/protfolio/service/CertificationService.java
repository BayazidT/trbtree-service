package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.CertificationRequest;
import com.trbtree.service.modules.protfolio.dto.CertificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CertificationService {
    List<CertificationResponse> getCertifications(UUID userId);

    CertificationResponse addCertification(CertificationRequest request, UUID userId);

    CertificationResponse updateCertification(CertificationRequest request, UUID id);
}
