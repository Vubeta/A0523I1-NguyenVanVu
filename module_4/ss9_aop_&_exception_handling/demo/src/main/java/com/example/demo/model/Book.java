package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private int bookQuantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowerCode> borrowerCodes;

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public List<BorrowerCode> getBorrowerCodes() {
        return borrowerCodes;
    }

    public void setBorrowerCodes(List<BorrowerCode> borrowerCodes) {
        this.borrowerCodes = borrowerCodes;
    }
}
