package com.example.productmanagement.repository;

import com.example.productmanagement.model.Product;

import java.util.LinkedHashMap;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<String,Product> PRODUCTS = new LinkedHashMap<>();

    static {
        PRODUCTS.put("P001",new Product("P001", "RAM 8GB", 900000, "RAM 8GB DDR4 for laptop", "Kingmax"));
        PRODUCTS.put("P002",new Product("P002", "LAPTOP DELL XPS 17", 35000000, "Dell XPS 17 9700 i5-10300H RAM 8GB SSD 256GB FHD", "Dell"));
        PRODUCTS.put("P003",new Product("P003", "Sony SRS-XB10 Portable Speaker", 1100000, "Sony SRS-XB10: size 75x91mm 260g 5W IPX5", "Sony"));
        PRODUCTS.put("P004",new Product("P004", "Keyboard Rapoo V700-8A White Orange", 1300000, "Rapoo V700-8A 4000mAh 310.1x120.2x35.5mm Bluetooth5.0 USB2.0", "Rapoo"));
        PRODUCTS.put("P005",new Product("P005", "Mouse Logitech MX Anywhere 2S", 1190000, "Logitech MX 2S 500mAh 200-4000DPI Bluetooth USB 106g 100.3x61.6x34.4mm", "Logitech"));
    }

    @Override
    public Map<String, Product> getAll() {
        return PRODUCTS;
    }
}
