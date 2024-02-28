package com.mjc.school.service.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDtoRequest {

    private Long id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Long newsId;
}
