package com.mjc.school.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "COMMENT")
@Data
@ToString(exclude = {"newsModel"})
@EqualsAndHashCode(exclude = {"id"})
public class CommentModel implements BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    //@Column(nullable = false)
    @Length(min = 3, max = 255)
    private String content;

    //@Column(nullable = false)
    private LocalDateTime created;

    //@Column(nullable = false)
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
