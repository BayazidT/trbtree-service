package com.trbtree.service.modules.protfolio.service;

import com.trbtree.service.modules.protfolio.dto.LanguageRequest;
import com.trbtree.service.modules.protfolio.dto.LanguageResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface LanguageService {
    List<LanguageResponse> getLanguages(UUID userId);

    LanguageResponse addLanguage(LanguageRequest languageRequest, UUID userId);

    LanguageResponse updateLanguage(LanguageRequest languageRequest, java.util.UUID id);
}
