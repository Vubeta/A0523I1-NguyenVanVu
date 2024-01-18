package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> showList();
    void saveBlog(Blog blog);
    boolean deleteBlog(int blogId);
    Blog findBlogById(int blogId);
    List<Blog> findBlog(String keyword);
}
