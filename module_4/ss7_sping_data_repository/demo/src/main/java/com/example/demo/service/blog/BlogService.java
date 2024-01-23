package com.example.demo.service.blog;

import com.example.demo.model.Blog;
import com.example.demo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

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
    public Page<Blog> findAll(Pageable pageable, String titleAuthorFind, String categoryNameFind) {
        return this.iBlogRepository.findAllByTitle(pageable, "%" + titleAuthorFind + "%", "%" + categoryNameFind + "%");
    }
}
