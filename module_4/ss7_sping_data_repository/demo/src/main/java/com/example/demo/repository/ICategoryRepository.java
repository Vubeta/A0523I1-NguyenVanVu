package com.example.demo.repository;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select c from Category c where c.categoryStatus = true and c.categoryName like :categoryNameFind")
    List<Category> selectAll(@Param("categoryNameFind") String categoryNameFind);
}
