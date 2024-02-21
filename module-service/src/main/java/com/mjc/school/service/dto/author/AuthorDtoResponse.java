package com.mjc.school.service.dto.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDtoResponse {

    private Long id;
    private String name;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateTime;


}
