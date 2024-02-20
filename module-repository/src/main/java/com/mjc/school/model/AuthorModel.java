package com.mjc.school.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
@Data
@ToString(exclude = "newsList")
@EqualsAndHashCode(exclude = "id")
public class AuthorModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 15, unique = true)
    @Length(min = 3, max = 15)
    private String name;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime lastUpdateTime;

    @OneToMany(mappedBy = "authorModel")
    private List<NewsModel> newsList;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
