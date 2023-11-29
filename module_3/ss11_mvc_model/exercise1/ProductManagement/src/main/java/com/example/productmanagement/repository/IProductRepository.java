package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.Map;

public interface IProductRepository {
    Map<String, Product> getAll();
}
