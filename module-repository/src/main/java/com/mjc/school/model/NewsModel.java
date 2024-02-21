package com.mjc.school.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "NEWS")
@Data
@ToString(exclude = {"tagModels", "authorModel", "commentModelList"})
@EqualsAndHashCode(exclude = {"id", "tagModels", "commentModelList"})
public class NewsModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Column(nullable = false, length = 30)
    // @Length(min = 5, max = 30)
    @NonNull
    private String title;

    // @Column(nullable = false)
    //@Length(min = 5, max = 255)
    @NonNull
    private String content;

    // @Column(nullable = false)
    //@CreatedDate
    @NonNull
    private LocalDateTime createDate;

    //@Column(nullable = false)
    //@LastModifiedDate
    @NonNull
    private LocalDateTime lastUpdateTime;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "id")
    private AuthorModel authorModel;

    @OneToMany(mappedBy = "newsModel")
    private List<CommentModel> commentModelList = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "NEWS_TAG",
            joinColumns = @JoinColumn(name = "news_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "ID"))
    private List<TagModel> tagModels;
}

/*
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = {"tagModelSet", "authorModel", "commentModelList"})
@EqualsAndHashCode(exclude = {"id", "tagModelSet", "commentModelList"})
public class NewsModel implements BaseEntity<Long>{
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		@NonNull
		private String title;
		@NonNull
		private String content;
		@NonNull
		private LocalDateTime createDate;
		@NonNull
		private LocalDateTime lastUpdateDate;
		@ManyToOne(cascade={CascadeType.MERGE})
		@JoinColumn(name = "AUTHOR_ID", referencedColumnName = "id")
		private AuthorModel authorModel;
		@OneToMany(mappedBy = "newsModel")
		private List<CommentModel> commentModelList = new ArrayList<>();
		@ManyToMany(cascade={CascadeType.MERGE})
		@JoinTable(name="NEWS_TAG",
						joinColumns=@JoinColumn(name="TAG_ID", referencedColumnName = "id"),
						inverseJoinColumns=@JoinColumn(name="NEWS_ID", referencedColumnName = "ID"))
		private Set<TagModel> tagModelSet = new HashSet<>();
}

 */