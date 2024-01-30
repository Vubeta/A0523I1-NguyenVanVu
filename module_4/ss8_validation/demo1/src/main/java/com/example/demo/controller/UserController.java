package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/show-create")
    public ModelAndView showFormSCreate(Model model){
        return new ModelAndView("/register","user",new User());
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        new User().validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/register";
        }
        iUserService.createUser(user);
        return "redirect:/show-create";
    }
}
