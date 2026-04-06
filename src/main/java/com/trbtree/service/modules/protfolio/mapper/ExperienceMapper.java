package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.ExperienceRequest;
import com.trbtree.service.modules.protfolio.dto.ExperienceResponse;
import com.trbtree.service.modules.protfolio.entity.Experience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {
    Experience toEntity(ExperienceRequest dto);
    ExperienceResponse toDTO(Experience entity);
}