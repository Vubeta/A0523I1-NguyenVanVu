package com.example.demo.repository;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(" select b from Blog b where b.blogStatus = true and b.blogTitle like :titleAuthorFind and b.blogAuthor like :titleAuthorFind and b.category.categoryName like :categoryName")
    Page<Blog> findAllByTitle(Pageable pageable, @Param("titleAuthorFind") String titleAuthorFind, @Param("categoryName") String categoryName);
}
