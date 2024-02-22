package com.mjc.school.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@ToString(exclude = "newsModelSet")
@EqualsAndHashCode(exclude = {"id", "newsModelSet"})
public class TagModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 15)
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "tagModelSet", cascade = {CascadeType.MERGE})
    private Set<NewsModel> newsModelSet = new HashSet<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}

