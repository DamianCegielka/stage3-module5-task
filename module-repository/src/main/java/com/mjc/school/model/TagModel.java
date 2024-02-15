package com.mjc.school.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
@Data
public class TagModel implements BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tagModels", fetch = FetchType.LAZY)
    private List<NewsModel> newsModels;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

}
