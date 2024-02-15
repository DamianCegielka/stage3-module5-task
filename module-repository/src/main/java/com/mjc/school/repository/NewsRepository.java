package com.mjc.school.repository;

import com.mjc.school.model.NewsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<NewsModel, Long> {
    @Query("SELECT n FROM NewsModel n JOIN n.tagModels t WHERE t.name LIKE CONCAT('%', :tagName, '%')")
    List<NewsModel> findAllByTagModelName(@Param("tagName") String tagName);
    @Query("SELECT n FROM NewsModel n JOIN n.tagModels t WHERE t.id LIKE CONCAT('%', :tagId, '%')")
    List<NewsModel> findAllByTagModelId(@Param("tagId") Long tagId);
    @Query("SELECT n FROM NewsModel n JOIN n.authorModel a WHERE a.name = :authorName")
    List<NewsModel> findAllByAuthorModelName(@Param(value = "authorName") String authorName);
    @Query("SELECT n FROM NewsModel n WHERE n.title LIKE CONCAT('%', :title, '%')")
    List<NewsModel> findAllByTitle(@Param(value = "title") String title);
    @Query("SELECT n FROM NewsModel n WHERE n.content LIKE CONCAT('%', :content, '%')")
    List<NewsModel> findAllByContent(@Param(value = "content") String content);




}
