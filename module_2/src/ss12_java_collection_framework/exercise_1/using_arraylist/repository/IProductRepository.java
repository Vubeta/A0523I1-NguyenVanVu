package ss12_java_collection_framework.exercise_1.using_arraylist.repository;

import ss12_java_collection_framework.exercise_1.using_arraylist.model.Product;

import java.util.ArrayList;

public interface IProductRepository {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(int id);
    ArrayList<Product> getListProduct();
    void findProductByName(String name);
    void sortListProductByPrice(int choiceNum);
}
