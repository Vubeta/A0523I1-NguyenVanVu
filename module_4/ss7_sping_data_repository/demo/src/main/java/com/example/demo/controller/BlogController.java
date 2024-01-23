package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.model.Category;
import com.example.demo.service.blog.IBlogService;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return iCategoryService.selectAll("");
    }

    @GetMapping("/")
    public String showBlogs(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                                   @RequestParam(value = "titleAuthorFind", defaultValue = "", required = false) String titleAuthorFind,
                                   @RequestParam(value = "categoryNameFind", defaultValue = "", required = false) String categoryNameFind,
                                   Model model) {
        Sort sort = Sort.by("date").ascending();
        Pageable pageable = PageRequest.of(page, 3,sort);
        Page<Blog> blogs = this.iBlogService.findAll(pageable, titleAuthorFind,categoryNameFind);
        model.addAttribute("blogs", blogs);
        model.addAttribute("titleAuthorFind", titleAuthorFind);
        model.addAttribute("categoryNameFind", categoryNameFind);
        return "/blog/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/blog/create", "blog", new Blog());
    }

    @PostMapping("/create")
    public String addNewBlog(Blog blog) {
        blog.setDate(new Date());
        iBlogService.saveBlog(blog);
        return "redirect:/blog/";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("blogId") int blogId) {
        iBlogService.deleteBlog(blogId);
        return "redirect:/blog/";
    }

    @GetMapping("/seeMore/{id}")
    public ModelAndView showBlog(@PathVariable Integer id) {
        return new ModelAndView("/blog/detail", "blog", iBlogService.findBlogById(id));
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Integer id) {
        return new ModelAndView("/blog/update", "blog", iBlogService.findBlogById(id));
    }

    @PostMapping("/update")
    public String editBlog(@ModelAttribute("blog") Blog blog) {
        iBlogService.saveBlog(blog);
        return "redirect:/blog/";
    }
}