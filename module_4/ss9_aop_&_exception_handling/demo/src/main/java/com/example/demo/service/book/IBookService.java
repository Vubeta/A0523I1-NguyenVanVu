package com.example.demo.service.book;

import com.example.demo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    void saveBook(Book book);
    void reduceQuantity(int id);
    void increaseQuantity(int id);
    Book findById(int id);
    String createBookCode();
    Page<Book> findAll(Pageable pageable);
}
