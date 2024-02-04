package com.example.demo.service.book;

import com.example.demo.model.Book;
import com.example.demo.repository.book.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public void saveBook(Book book) {
        if (book != null) {
            iBookRepository.save(book);
        }
    }

    @Override
    public void reduceQuantity(int id) {
            iBookRepository.reduceQuantity(id);
    }

    @Override
    public void increaseQuantity(int id) {
            iBookRepository.increaseQuantity(id);
    }

    @Override
    public Book findById(int id) {
        Optional<Book> bookOptional = iBookRepository.findById(id);
        Book book = null;

        if (bookOptional.isPresent()){
            book = bookOptional.get();
        }

        return book;
    }

    @Override
    public String createBookCode() {
        return null;
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }
}
