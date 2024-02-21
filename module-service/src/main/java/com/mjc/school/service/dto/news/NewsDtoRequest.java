package com.mjc.school.service.dto.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDtoRequest {

    private Long id;
    private String title;
    private String content;
    private Long authorId;
    private String tagId;
    private String tagNames;
    private String authorName;

}