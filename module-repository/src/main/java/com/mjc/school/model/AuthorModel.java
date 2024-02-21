package com.mjc.school.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "AUTHOR")
@Data
@ToString(exclude = "newsList")
@EqualsAndHashCode(exclude = "id")
public class AuthorModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false, length = 15, unique = true)
    //@Length(min = 3, max = 15)
    @NonNull
    private String name;

    //@Column(nullable = false)
    //@CreatedDate
    @NonNull
    private LocalDateTime createDate;

    //@Column(nullable = false)
    //@LastModifiedDate
    @NonNull
    private LocalDateTime lastUpdateTime;

    @OneToMany(mappedBy = "authorModel")
    private List<NewsModel> newsList = new ArrayList<>();

}
