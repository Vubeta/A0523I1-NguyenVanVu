package com.example.demo1.repository;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAllProducts();
    void save(Product product);
    Product selectProduct(int productId);
    void updateProduct(Product product);
    void deleteProduct(int productId);
    List<Product> findProductByName(String productNameInput);
}
