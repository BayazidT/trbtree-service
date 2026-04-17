package com.trbtree.service.modules.protfolio.mapper;

import com.trbtree.service.modules.protfolio.dto.SkillRequest;
import com.trbtree.service.modules.protfolio.dto.SkillResponse;
import com.trbtree.service.modules.protfolio.entity.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toEntity(SkillRequest dto);
    SkillResponse toDTO(Skill entity);
}
