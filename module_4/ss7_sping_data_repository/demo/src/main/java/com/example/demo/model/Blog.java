package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

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
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Date date;
    private boolean blogStatus=true;

    public Blog() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
