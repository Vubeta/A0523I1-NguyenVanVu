package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SandwichController {
    private String[] arr = {"Lettuce","Tomato","Mustard","Sprouts"};
    private List<String[]> list = new ArrayList<>();

    @GetMapping(value = {"/","sandwich"})
    public String home(Model model) {
        model.addAttribute("arr",arr);
        return "/sandwich";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        list.add(condiment);
        model.addAttribute("list",list);
        return "/list-sandwich";
    }
}
