package com.mjc.school.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
@Data
public class CommentModel implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Length(min = 5, max = 255)
    private String content;

    @Column(nullable = false)
    private LocalDateTime created;

    @Column(nullable = false)
    private LocalDateTime modified;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "NEWS_ID", referencedColumnName = "id")
    private NewsModel newsModel;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}
