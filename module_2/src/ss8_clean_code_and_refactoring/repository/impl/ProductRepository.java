package ss8_clean_code_and_refactoring.repository.impl;

import ss8_clean_code_and_refactoring.repository.IProductRepository;
import ss8_clean_code_and_refactoring.model.Product;

public class ProductRepository implements IProductRepository {
    private static Product[] products = new Product[20];
    static{
        products[0] = new Product(1,"MacBook Air 2020",18990000,
                        "13.3 inch MGN63SA/A (M1/8GB/SSD256GB) (Xám)");
        products[1] = new Product(2,"MacBook Pro 2022",29290000,
                        "13.3 inch MNEP3SA/A (M2/ 8GB/ SSD 256GB)");
        products[2] = new Product(3,"Laptop APPLE MacBook Air 2023",40890000,
                        "Apple M2/RAM 8GB/512GB SSD/ macOS");
    }
    @Override
    public Product[] getListProduct() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if(products[i] != null) {
                products[i] = product;
                break;
            }
        }
    }

    @Override
    public void deleteProductById(int idProduct) {
        for (int i = 0; i < products.length; i++) {
            if(products[i].getId() == idProduct) {
                products[i] = null;
            }
            break;
        }
    }

    @Override
    public float[] findProductByName(String nameProductUser) {
        float[] ratePercent = new float[getListProduct().length];
        char[] charsUser = nameProductUser.toCharArray();
        float rateNum = 0.0f;
        for (int i=0; i<getListProduct().length; i++) {
            String nameProduct = getListProduct()[i].getName();
            char[] charsCheck = nameProduct.toCharArray();
            for (char charCheck : charsCheck) {
                for (char charUser : charsUser) {
                    if(charUser!=charCheck) {
                        rateNum = 0.0f;
                    } else if (charUser==charCheck) {
                        rateNum += 1/nameProduct.length();
                    }
                }
            }
            ratePercent[i] = rateNum;
        }
        return ratePercent;
    }
}