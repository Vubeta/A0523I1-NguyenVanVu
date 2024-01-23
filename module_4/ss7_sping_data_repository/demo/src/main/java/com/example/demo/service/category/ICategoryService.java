package com.example.demo.service.category;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> selectAll(String categoryNameFind);
    void save(Category category);
    boolean delete(int id);
    Category findById(int id);
}
