package com.mjc.school.service.mapper;

import com.mjc.school.model.TagModel;
import com.mjc.school.service.dto.tag.TagDtoResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


public interface TagModelMapperToTagDtoResponse {
    TagDtoResponse tagModelToDto(TagModel tagModel);
}
