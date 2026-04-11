package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.HobbyRequest;
import com.trbtree.service.modules.protfolio.dto.HobbyResponse;
import com.trbtree.service.modules.protfolio.dto.LanguageRequest;
import com.trbtree.service.modules.protfolio.dto.LanguageResponse;
import com.trbtree.service.modules.protfolio.entity.Hobby;
import com.trbtree.service.modules.protfolio.entity.Language;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    Language toEntity(LanguageRequest dto);
    LanguageResponse toDTO(Language entity);
}
