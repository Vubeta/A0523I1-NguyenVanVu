package ss15_exception_handling_and_debug;

import java.util.Scanner;

public class IllegalTriangleException extends Exception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Enter side a: ");
            double a = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter side b: ");
            double b = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter side c: ");
            double c = Double.parseDouble(scanner.nextLine());
            try {
                if (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a) {
                    throw new IllegalTriangleException("This is not a valid triangle");
                } else {
                    flag = false;
                }
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            };
        } while (flag);
        System.out.println("This is a valid triangle");
    }

    public IllegalTriangleException(String message) {
        super(message);
    }
}
