package com.example.demo.service.product;

import com.example.demo.model.Product;
import com.example.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void delete(int id) {
        iProductRepository.deleteById(id);
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        Optional<Product> optionalProduct = iProductRepository.findById(id);
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }
        return product;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    @Override
    public Product findByCode(String code) {
        return iProductRepository.findByProductCode(code);
    }
}
