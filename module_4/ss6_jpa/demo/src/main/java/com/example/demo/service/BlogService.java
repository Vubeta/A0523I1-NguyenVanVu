package com.example.demo.service;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> showList() {
        return iBlogRepository.findAllActiveBlog();
    }

    @Override
    public void saveBlog(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public boolean deleteBlog(int blogId) {
        boolean isDeleted = false;
        Optional<Blog> optionalBlog = iBlogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            Blog blog = optionalBlog.get();
            blog.setBlogStatus(false);
            iBlogRepository.save(blog);
            isDeleted = true;
        }
        return isDeleted;
    }

    @Override
    public Blog findBlogById(int blogId) {
        Blog blog = null;
        Optional<Blog> optionalBlog = iBlogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            blog = optionalBlog.get();
        }
        return blog;
    }

    @Override
    public List<Blog> findBlog(String keyword) {
        return iBlogRepository.findBlogByTitleOrAuthor(keyword);
    }
}
