package com.example.demo.controller;

import com.example.demo.model.Music;
import com.example.demo.service.IMusicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    IMusicService iMusicService;

    @GetMapping("/")
    public String showMusics(@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
                             Model model){
        Pageable pageable = PageRequest.of(page,7);
        Page<Music> musics = iMusicService.findAll(pageable);
        model.addAttribute("musics", musics);
        return "/show";
    }

    @GetMapping("/show-form-create")
    public ModelAndView showCreate(){
        return new ModelAndView("/create","music", new Music());
    }

    @PostMapping("/create-music")
    public String create(@Valid @ModelAttribute("music") Music music, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        iMusicService.saveMusic(music);
        return "redirect:/music/";
    }
}
