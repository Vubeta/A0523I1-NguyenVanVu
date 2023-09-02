package ss8_clean_code_and_refactoring.service.impl;

import ss8_clean_code_and_refactoring.model.Product;
import ss8_clean_code_and_refactoring.service.IProductService;
import ss8_clean_code_and_refactoring.repository.IProductRepository;
import ss8_clean_code_and_refactoring.repository.impl.ProductRepository;

import java.util.Scanner;

public class ProductService implements IProductService {
    static Scanner scanner = new Scanner(System.in);
    private IProductRepository productRepository = new ProductRepository();

    @Override
    public void display() {
        Product[] products = productRepository.getListProduct();
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println((i + 1) + ". " + products[i]);
            }
        }
    }

    @Override
    public void add() {
        System.out.print("Enter the id of product: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the name of product: ");
        String name = scanner.nextLine();
        System.out.print("Enter the price of product (VND): ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the detail of product: ");
        String detail = scanner.nextLine();
        Product product = new Product(id, name, price, detail);
        productRepository.addProduct(product);
    }

    @Override
    public void delete() {
        System.out.println("Enter the id of product which you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        productRepository.deleteProductById(id);
    }

    @Override
    public void find() {
        System.out.print("Enter the name of product which you want to find: ");
        String name = scanner.nextLine();
        productRepository.findProductByName(name);
    }
}
