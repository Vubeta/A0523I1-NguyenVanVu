package com.example.demo.service;

import com.example.demo.model.Music;
import com.example.demo.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository iMusicRepository;

    @Override
    public void saveMusic(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iMusicRepository.findAll(pageable);
    }
}
