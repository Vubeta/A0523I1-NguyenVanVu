package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAll();
    void deleteProduct(String productId);
    void addProduct(Product product);
    void updateProduct(String productId, Product product);
    List<Product> findProduct(String productName);
    Product getProduct(String productId);
}
