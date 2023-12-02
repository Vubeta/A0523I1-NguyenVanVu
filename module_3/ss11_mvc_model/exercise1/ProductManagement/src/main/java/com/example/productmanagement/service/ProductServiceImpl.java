package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.repository.IProductRepository;
import com.example.productmanagement.repository.ProductRepositoryImpl;

import java.util.*;

public class ProductServiceImpl implements IProductService {
    private final IProductRepository PRODUCT_REPOSITORY = new ProductRepositoryImpl();
    @Override
    public List<Product> showAll() {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        return new ArrayList<>(products.values());
    }

    @Override
    public void deleteProduct(String productId) {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        products.remove(productId);
    }

    @Override
    public void addProduct(Product product) {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        products.put(product.getProductId(),product);
    }

    @Override
    public void updateProduct(String productId, Product product) {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        products.replace(productId,product);
    }

    @Override
    public List<Product> findProduct(String productName) {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        List<String> keyList = getMatchingList(productName);
        List<Product> productList = new ArrayList<>();
        for (String s : keyList) {
            productList.add(products.get(s));
        }
        return productList;
    }

    @Override
    public Product getProduct(String productId) {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        return products.get(productId);
    }

    //used for findProduct
    public Integer compareTwoArrays(String[] arr1, String[] arr2) {
        int num=0;
        for (String s : arr1) {
            if(Arrays.asList(arr2).contains(s)) {
                num++;
            }
        }
        return num;
    }

    //used for findProduct
    public List<String> getMatchingList(String productName) {
        Map<String,Product> products = PRODUCT_REPOSITORY.getAll();
        //lower & split string
        String[] words = productName.toLowerCase().split("\\s+");
        //create treemap
        TreeMap<Integer,String> nums = new TreeMap<>();

        for (Map.Entry<String,Product> entry : products.entrySet()) {
            String key = entry.getKey();
            Product product = entry.getValue();
            String[] wordsProduct = product.getProductName().toLowerCase().split("\\s+");
            int countSame = compareTwoArrays(words,wordsProduct);
            if (countSame > 0)
                nums.put(countSame,key);
        }

        // Lấy một NavigableMap với thứ tự giảm dần của key
        NavigableMap<Integer,String> descendingMap = nums.descendingMap();

        return new ArrayList<>(descendingMap.values());
    }
}
