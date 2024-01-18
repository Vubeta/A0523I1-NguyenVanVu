package com.example.demo.controller;

import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/")
    public ModelAndView showList(){
        return new ModelAndView("/list","blogList",iBlogService.showList());
    }

    @GetMapping("/show-form-create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/create","blog", new Blog());
    }

    @PostMapping("/addBlog")
    public String addNewBlog(Blog blog) {
        iBlogService.saveBlog(blog);
        return "redirect:/";
    }

    @PostMapping("/deleteBlog")
    public String deleteBlog(@RequestParam("blogId") int blogId) {
        iBlogService.deleteBlog(blogId);
        return "redirect:/";
    }

    @GetMapping("/seeMore/{id}")
    public ModelAndView showBlog(@PathVariable Integer id){
        return new ModelAndView("/detail","blog",iBlogService.findBlogById(id));
    }

    @GetMapping("/updateBlog/{id}")
    public ModelAndView showFormUpdate(@PathVariable Integer id){
        return new ModelAndView("/update","blog",iBlogService.findBlogById(id));
    }

    @PostMapping("/editBlog")
    public String editBlog(Blog blog){
        iBlogService.saveBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/findBlog")
    public ModelAndView findBlog(@RequestParam("blogTitleInput") String keyword){
        return new ModelAndView("/list","blogList",iBlogService.findBlog(keyword));
    }
}
