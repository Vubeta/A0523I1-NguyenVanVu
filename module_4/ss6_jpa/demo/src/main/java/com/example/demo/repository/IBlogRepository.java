package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query("select b from Blog b where b.blogStatus = true")
    List<Blog> findAllActiveBlog();

    @Query("select b from Blog b where lower(b.blogTitle) like lower(concat('%', :keyword, '%')) or lower(b.blogAuthor) like lower(concat('%', :keyword, '%'))")
    List<Blog> findBlogByTitleOrAuthor(@Param("keyword") String keyword);
}
