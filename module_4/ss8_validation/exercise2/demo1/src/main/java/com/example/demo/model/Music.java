package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int musicId;
    @NotBlank(message = "Music name is not be empty")
    @Size(max = 800, message = "Music name is not exceed 800 characters")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Music name is not contain special characters")
    private String musicName;
    @NotBlank(message = "Music artist is not be empty")
    @Size(max = 300, message = "Music artist is not exceed 300 characters")
    @Pattern(regexp = "^[A-Za-z0-9 ]+$", message = "Music artist is not contain special characters")
    private String musicArtist;
    @NotBlank(message = "Music genre is not be empty")
    @Size(max = 1000, message = "Music genre is not exceed 1000 characters")
    @Pattern(regexp = "^[A-Za-z0-9\\, ]+$", message = "Music genre is not contain special characters")
    private String musicGenre;

    public Music() {
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }
}
