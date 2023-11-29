package com.example.productmanagement.model;

public class Product {
    private String productId;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String producer;

    public Product(String productId, String productName, double productPrice, String productDescription, String producer) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.producer = producer;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String infoProduct() {
        return productId + "," + productName + "," + productPrice + "," + productDescription + "," + producer;
    }
}
