package com.mjc.school.service.mapper;


import com.mjc.school.model.CommentModel;
import com.mjc.school.service.dto.comment.CommentDtoResponse;
import org.mapstruct.Mapper;

@Mapper
public interface CommentModelMapperToCommentDtoResponse {

    CommentDtoResponse map(CommentModel authorModel);

}
