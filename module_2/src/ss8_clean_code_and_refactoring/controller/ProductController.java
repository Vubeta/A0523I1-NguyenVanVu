package ss8_clean_code_and_refactoring.controller;

import ss8_clean_code_and_refactoring.service.IProductService;
import ss8_clean_code_and_refactoring.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    static Scanner scanner = new Scanner(System.in);
    public static void displayMenu() {
        IProductService productService = new ProductService();
        boolean isExit = false;
        do {
            System.out.println("Please enter your option: ");
            System.out.println("1. Display product(s)" +
                                "\n2. Add new product" +
                                "\n3. Delete product" +
                                "\n4. Find prodcut" +
                                "\n5. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.display();
                    break;
                case 2:
                    productService.add();
                    break;
                case 3:
                    productService.delete();
                    break;
                case 4:
                    productService.find();
                    break;
                default:
                    isExit = true;
            }
        } while (!isExit);
        if(isExit) {
            System.exit(0);
        }
    }
}
