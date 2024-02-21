package com.mjc.school.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "TAGS")
@Data
@ToString(exclude = "newsModels")
@EqualsAndHashCode(exclude = {"id", "newsModels"})
public class TagModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Length(min=3, max=15)
    @NonNull
    private String name;

    @ManyToMany(mappedBy = "tagModels", cascade = {CascadeType.MERGE})
    private List<NewsModel> newsModels = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
