package com.example.test_demo.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.example.test_demo.model.CurrencyConversion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConvertController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("conversion", new CurrencyConversion());
        return "/convert";
    }

    @PostMapping("/conversion")
    public String convertCurrency(
            @RequestParam("usdAmount") double usdAmount,
            @RequestParam("exchangeRate") double exchangeRate,
            RedirectAttributes redirectAttributes
    ) {
        double vndAmount = usdAmount * exchangeRate;
        CurrencyConversion result = new CurrencyConversion(exchangeRate, usdAmount, vndAmount);
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/conversion-result";
    }

    @GetMapping("/conversion-result")
    public String showConversionResult() {
        return "/conversion-result";
    }
}
