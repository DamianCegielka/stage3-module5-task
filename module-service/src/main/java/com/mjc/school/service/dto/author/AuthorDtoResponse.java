package com.mjc.school.service.dto.author;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthorDtoResponse {

    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;

}
