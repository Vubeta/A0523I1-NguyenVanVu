package ss8_clean_code_and_refactoring.repository;

import ss8_clean_code_and_refactoring.model.Product;

public interface IProductRepository {
    Product[] getListProduct();
    void addProduct(Product product);
    void deleteProductById(int idProduct);
    float[] findProductByName(String nameProduct);
}
