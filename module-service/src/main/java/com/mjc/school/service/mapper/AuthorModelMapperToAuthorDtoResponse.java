package com.mjc.school.service.mapper;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.service.dto.author.AuthorDtoResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AuthorModelMapperToAuthorDtoResponse {
    AuthorDtoResponse map(AuthorModel authorModel);
}
