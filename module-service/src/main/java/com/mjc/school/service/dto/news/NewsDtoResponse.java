package com.mjc.school.service.dto.news;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NewsDtoResponse {

    private Long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;
    private Long authorId;

}