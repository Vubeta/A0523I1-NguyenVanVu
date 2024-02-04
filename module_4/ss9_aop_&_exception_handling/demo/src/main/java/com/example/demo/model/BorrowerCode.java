package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BorrowerCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowerCodeId;
    @Column(unique = true)
    private String borrowerCode;
    @ManyToOne
    private Book book;

    public BorrowerCode() {
    }

    public int getBorrowerCodeId() {
        return borrowerCodeId;
    }

    public void setBorrowerCodeId(int borrowerCodeId) {
        this.borrowerCodeId = borrowerCodeId;
    }

    public String getBorrowerCode() {
        return borrowerCode;
    }

    public void setBorrowerCode(String borrowerCode) {
        this.borrowerCode = borrowerCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
