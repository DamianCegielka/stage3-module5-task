package com.mjc.school.service.mapper;

import com.mjc.school.model.CommentModel;
import com.mjc.school.service.dto.comment.CommentDtoRequest;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CommentDtoRequestMapperToCommentModel {

    CommentModel map(CommentDtoRequest commentDtoRequest);

    CommentModel mapUpdate(CommentDtoRequest commentDtoRequest);
}
