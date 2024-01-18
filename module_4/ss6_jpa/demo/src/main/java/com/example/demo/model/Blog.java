package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int blogId;
    private String blogAuthor;
    private String blogTitle;
    @Column(columnDefinition = "LONGTEXT")
    private String blogContent;
    private String blogImg;
    private boolean blogStatus=true;

    public Blog() {
    }

    public Blog(String blogAuthor, String blogTitle, String blogContent, String blogImg) {
        this.blogAuthor = blogAuthor;
        this.blogTitle = blogTitle;
        this.blogContent = blogContent;
        this.blogImg = blogImg;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogImg() {
        return blogImg;
    }

    public void setBlogImg(String blockImg) {
        this.blogImg = blockImg;
    }

    public boolean isBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(boolean blogStatus) {
        this.blogStatus = blogStatus;
    }
}
