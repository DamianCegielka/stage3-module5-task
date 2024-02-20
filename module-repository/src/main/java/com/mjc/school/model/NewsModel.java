package com.mjc.school.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "news")
@Data
@ToString(exclude = {"tagModels", "authorModel" , "commentModelList"})
@EqualsAndHashCode(exclude = {"id", "tagModels", "commentModelList"})
public class NewsModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    @Length(min = 5, max = 30)
    private String title;

    @Column(nullable = false)
    @Length(min = 5, max = 255)
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime lastUpdateTime;
    private Long authorId;

    @ManyToOne
    @JoinColumn(name = "authorId", insertable = false, updatable = false)
    private AuthorModel authorModel;

    @OneToMany(mappedBy = "newsModel")
    private List<CommentModel> commentModelList = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "news_tag",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<TagModel> tagModels;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
