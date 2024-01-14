package com.example.demo1.repository;

import com.example.demo1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAllProducts();
    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
    List<Product> findProductByName(String productNameInput);
    Product selectProduct(int id);
    boolean insertProduct(Product product);
}
