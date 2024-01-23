package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    void saveBlog(Blog blog);
    boolean deleteBlog(int blogId);
    Blog findBlogById(int blogId);
    Page<Blog> findAll(Pageable pageable, String titleAuthorFind, String categoryNameFind);
}
