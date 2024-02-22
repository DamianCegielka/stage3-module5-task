package com.mjc.school.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = {"newsModel"})
@EqualsAndHashCode(exclude = {"id"})
public class CommentModel implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String content;

    private LocalDateTime created;

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
