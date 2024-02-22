package com.mjc.school.service.mapper;

import com.mjc.school.model.TagModel;
import com.mjc.school.service.dto.tag.TagDtoResponse;


public interface TagModelMapperToTagDtoResponse {
    TagDtoResponse tagModelToDto(TagModel tagModel);
}
