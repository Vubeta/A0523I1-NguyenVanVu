package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if (entry.getKey().getProductId() == product.getProductId()){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            if (entry.getKey().getProductId() == product.getProductId()) {
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void reduceProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            if (itemEntry.getValue() > 1) {
                Integer newQuantity = itemEntry.getValue() - 1;
                products.replace(itemEntry.getKey(), newQuantity);
            }
        }
    }

    public void removeProduct(Product product) {
        if (checkItemInCart(product)) {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            System.out.println(products.remove(itemEntry.getKey(), itemEntry.getValue()));
        }
    }

    //SL product da pick trong gio hang
    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    // SL item trong products
    public Integer countItemQuantity(){
        return products.size();
    }

    public double countTotalPayment(){
        double payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            payment += entry.getValue() * entry.getKey().getProductPrice();
        }
        return payment;
    }
}