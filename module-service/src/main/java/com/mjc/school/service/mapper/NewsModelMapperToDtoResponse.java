package com.mjc.school.service.mapper;

import com.mjc.school.model.NewsModel;
import com.mjc.school.service.dto.news.NewsDtoResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface NewsModelMapperToDtoResponse {
    NewsDtoResponse map(NewsModel model);
}
