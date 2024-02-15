package com.mjc.school.service.mapper;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface AuthorModelMapperToAuthorDtoResponse {
    AuthorDtoResponse map(AuthorModel authorModel);
}
