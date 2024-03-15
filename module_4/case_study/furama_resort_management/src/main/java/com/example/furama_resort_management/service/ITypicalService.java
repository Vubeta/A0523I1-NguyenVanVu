package com.example.furama_resort_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITypicalService<T> {
    Page<T> findAll(Pageable pageable);
    void save(T t);
    void remove(int id);
    T findById(int id);
}