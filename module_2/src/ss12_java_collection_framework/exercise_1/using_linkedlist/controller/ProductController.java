package ss12_java_collection_framework.exercise_1.using_linkedlist.controller;

import ss12_java_collection_framework.exercise_1.using_linkedlist.service.IProductService;
import ss12_java_collection_framework.exercise_1.using_linkedlist.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    public static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        IProductService productService = new ProductService();
        boolean isExit = false;
        do {System.out.println("1. Add new product" +
                "\n2. Update information product by id" +
                "\n3. Delete product by id" +
                "\n4. Display list product" +
                "\n5. Find product by name" +
                "\n6. Sort product by price" +
                "\n7. Exit");
            System.out.print("Please enter your option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.update();
                    break;
                case 3:
                    productService.delete();
                    break;
                case 4:
                    productService.display();
                    break;
                case 5:
                    productService.find();
                    break;
                case 6:
                    productService.sort();
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
