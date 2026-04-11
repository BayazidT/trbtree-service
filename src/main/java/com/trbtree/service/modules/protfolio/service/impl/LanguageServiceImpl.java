package com.trbtree.service.modules.protfolio.service.impl;

import com.trbtree.service.modules.protfolio.dto.LanguageResponse;
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
    public List<LanguageResponse> getLanguages(UUID userId) {
        return List.of();
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
