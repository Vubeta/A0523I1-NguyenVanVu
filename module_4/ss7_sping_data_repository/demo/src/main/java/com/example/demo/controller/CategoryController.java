package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/")
    public String showCategories(@RequestParam(value = "categoryNameFind", defaultValue = "", required = false) String categoryNameFind,
                                 Model model) {
        model.addAttribute("categories", iCategoryService.selectAll(categoryNameFind));
        return "/category/list";
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate() {
        return new ModelAndView("/category/create", "category", new Category());
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category) {
        iCategoryService.save(category);
        return "redirect:/category/";
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable("id") Integer id) {
        return new ModelAndView("/category/update", "category", iCategoryService.findById(id));
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("category") Category category){
        iCategoryService.save(category);
        return "redirect:/category/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("categoryId") Integer id){
        iCategoryService.delete(id);
        return "redirect:/category/";
    }
}
