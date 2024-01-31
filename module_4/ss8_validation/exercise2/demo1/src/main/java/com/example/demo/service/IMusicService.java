package com.example.demo.service;

import com.example.demo.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    void saveMusic(Music music);
    Page<Music> findAll(Pageable pageable);
}
