package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> selectAll(String categoryNameFind) {
        return iCategoryRepository.selectAll("%"  + categoryNameFind + "%");
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public boolean delete(int id) {
        boolean isDeleted = false;
        Optional<Category> optionalCategory = iCategoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setCategoryStatus(false);
            iCategoryRepository.save(category);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public Category findById(int id) {
        Category category = null;
        iCategoryRepository.findById(id);
        Optional<Category> optionalCategory = iCategoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            category = optionalCategory.get();
        }
        return category;
    }
}
