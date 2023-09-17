package ss12_java_collection_framework.excercise_1.service.impl;

import ss12_java_collection_framework.excercise_1.model.Product;
import ss12_java_collection_framework.excercise_1.repository.IProductRepository;
import ss12_java_collection_framework.excercise_1.repository.impl.ProductRepository;
import ss12_java_collection_framework.excercise_1.service.IProductService;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductService implements IProductService {
    static Scanner scanner = new Scanner(System.in);
    private IProductRepository productRepository = new ProductRepository();

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
    public void update() {
        System.out.print("Enter the id of product which you want to update information: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the name of product which you want to update information: ");
        String name = scanner.nextLine();
        System.out.print("Enter the price of product (VND) which you want to update information: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter the detail of product which you want to update information: ");
        String detail = scanner.nextLine();
        Product product = new Product(id, name, price, detail);
        productRepository.updateProduct(product);
    }

    @Override
    public void delete() {
        System.out.println("Enter the id of product which you want to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        productRepository.deleteProductById(id);
    }

    @Override
    public void display() {
        ArrayList<Product> products = productRepository.getListProduct();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null) {
                System.out.println((i + 1) + ". " + products.get(i));
            }
        }
    }

    @Override
    public void find() {
        System.out.print("Enter the name of product which you want to find: ");
        String name = scanner.nextLine();
        productRepository.findProductByName(name);
    }

    @Override
    public void sort() {
        int yourChoice = 0;
        do {
            System.out.println("You want to sort product prices \n1. Ascending \n2. Descending?");
            System.out.print("Your choice is: ");
            yourChoice = Integer.parseInt(scanner.nextLine());
        } while (yourChoice != 1 && yourChoice != 2);

        switch (yourChoice) {
            case 1:
                productRepository.sortListProductByPrice(1);
                break;
            case 2:
                productRepository.sortListProductByPrice(2);
        }
    }
}
