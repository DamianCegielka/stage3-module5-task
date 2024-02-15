package com.mjc.school.service.dto.news;

import lombok.Data;

@Data
public class NewsDtoRequest {

    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private String tagIds;
    private String tagNames;
    private String authorName;

}