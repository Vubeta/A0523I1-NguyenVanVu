package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class DictionaryController {
    String[][] arr = {{"hello","xin chào"}, {"world","thế giới"}, {"cat","con mèo"}};

    @GetMapping("/")
    public String homeDictionary() {
        return "/dictionary";
    }

    @PostMapping("/find")
    public String findDictionary(@RequestParam("engInput") String engInput, Model model) {
        String result = null;
        for (String[] s : arr) {
            if (engInput.equals(s[0])) {
                result = s[0] + ": " + s[1];
                break;
            }
        }
        if (Objects.isNull(result)) {
            result = "Không tìm thấy kết quả";
        }
        model.addAttribute("result",result);
        return "/dictionary";
    }
}
