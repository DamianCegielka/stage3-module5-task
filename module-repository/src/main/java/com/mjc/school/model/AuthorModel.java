package com.mjc.school.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = "newsList")
@EqualsAndHashCode(exclude = "id")
public class AuthorModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private LocalDateTime createDate;

    @NonNull
    private LocalDateTime lastUpdateTime;

    @OneToMany(mappedBy = "authorModel")
    private List<NewsModel> newsList = new ArrayList<>();

}
