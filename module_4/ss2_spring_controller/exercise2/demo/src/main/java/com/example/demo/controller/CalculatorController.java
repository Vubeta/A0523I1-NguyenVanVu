package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping("/")
    public String home() {
        return "/calculator";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double firstNum,
                            @RequestParam double secondNum,
                            @RequestParam String calculation,
                            Model model
    ) {
        double result = 0.0;
        String cal = null;
        switch (calculation) {
            case "add":
                result = firstNum + secondNum;
                cal = "Addition";
                break;
            case "sub":
                result = firstNum - secondNum;
                cal = "Subtraction";
                break;
            case "mul":
                result = firstNum * secondNum;
                cal = "Multilication";
                break;
            case "div":
                result = firstNum / secondNum;
                cal = "Division";
                break;
            default:

        }
        model.addAttribute("result","Result " + cal + ": " + result);
        return "/calculator";
    }
}
