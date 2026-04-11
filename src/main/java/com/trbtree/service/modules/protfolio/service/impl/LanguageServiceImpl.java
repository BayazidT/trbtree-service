package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.LanguageRequest;
import com.trbtree.service.modules.protfolio.dto.LanguageResponse;
import com.trbtree.service.modules.protfolio.entity.Language;
import com.trbtree.service.modules.protfolio.mapper.LanguageMapper;
import com.trbtree.service.modules.protfolio.repository.LanguageRepository;
import com.trbtree.service.modules.protfolio.service.LanguageService;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {
    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Override
    public LanguageResponse updateLanguage(LanguageRequest languageRequest, UUID id) {
        Language oldLanguage = languageRepository.findById(id).orElse(null);
        Language language = languageMapper.toEntity(languageRequest);
        language.setUserId(oldLanguage.getUserId());
        languageRepository.delete(oldLanguage);
        Language response= languageRepository.save(language);
        return languageMapper.toDTO(response);    }

    @Override
    public LanguageResponse addLanguage(LanguageRequest languageRequest, UUID userId) {
        Language language = languageMapper.toEntity(languageRequest);
        language.setUserId(userId);
        Language response= languageRepository.save(language);
        return languageMapper.toDTO(response);
    }

    @Override
    public List<LanguageResponse> getLanguages(UUID userId) {
        return Optional.ofNullable(languageRepository.findByUserId(userId))
                .orElse(Collections.emptyList());
    }
//    @Override
//    public List<LanguageResponse> getLanguages(UUID userId) {
//        return Optional.ofNullable(languageRepository.findByUserId(userId))
//                .orElse(Collections.emptyList())
//                .stream()
//                .map(languageMapper::toDTO)
//                .toList();
//    }
    //Optional.ofNullable(certificationRepository.findByUserId(userId))
    //                .orElse(Collections.emptyList())
    //                .stream()
    //                .map(certificationMapper::toDTO)
    //                .toList();
}
