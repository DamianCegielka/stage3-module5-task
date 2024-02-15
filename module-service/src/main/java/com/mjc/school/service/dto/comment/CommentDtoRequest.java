package com.mjc.school.service.dto.comment;

import lombok.Data;


import java.time.LocalDateTime;

@Data
public class CommentDtoRequest {

    private Long id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Long newsId;
}
