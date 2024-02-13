package com.example.demo.service.product;

import com.example.demo.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    void save(Product product);
    void delete(int id);
    Product findById(int id);
    Page<Product> findAll(Pageable pageable);
    Product findByCode(String code);
}
