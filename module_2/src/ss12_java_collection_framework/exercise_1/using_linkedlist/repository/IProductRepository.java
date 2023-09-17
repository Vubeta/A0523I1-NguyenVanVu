package ss12_java_collection_framework.exercise_1.using_linkedlist.repository;

import ss12_java_collection_framework.exercise_1.using_linkedlist.model.Product;

import java.util.LinkedList;

public interface IProductRepository {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProductById(int id);
    LinkedList<Product> getListProduct();
    void findProductByName(String name);
    void sortListProductByPrice(int choiceNum);
}
