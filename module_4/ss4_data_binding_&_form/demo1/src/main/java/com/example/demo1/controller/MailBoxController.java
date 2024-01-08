package com.example.demo1.controller;

import com.example.demo1.model.MailBoxSettings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("mailbox")
public class MailBoxController {
    private String[] arrLanguages = {"English", "Vietnamese", "Japanese", "Chinese"};
    private Integer[] arrPageSize = {5, 10, 15, 25, 50, 100};
    private MailBoxSettings mailBoxSettings = new MailBoxSettings();

    @ModelAttribute("mailbox-settings")
    public MailBoxSettings mailBoxSettings(){
        return mailBoxSettings;
    }

    @RequestMapping("/show-form")
    public String showForm(Model model){
        model.addAttribute("languageList",arrLanguages);
        model.addAttribute("pageSizeList",arrPageSize);
        return "/mailbox_settings/mailbox-settings";
    }
    @RequestMapping(value = "/updateSettings", method = RequestMethod.POST)
    public String updateSettings(@ModelAttribute("mailbox-settings") MailBoxSettings newMailBoxSettings){
        mailBoxSettings.setLanguages(newMailBoxSettings.getLanguages());
        mailBoxSettings.setPageSize(newMailBoxSettings.getPageSize());
        mailBoxSettings.setSpamFilter(newMailBoxSettings.isSpamFilter());
        mailBoxSettings.setSignature(newMailBoxSettings.getSignature());
        return "redirect:/mailbox/show-form";
    }
}
