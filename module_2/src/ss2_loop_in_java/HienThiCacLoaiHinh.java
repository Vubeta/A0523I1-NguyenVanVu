package ss2_loop_in_java;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(
            "Menu\n" +
            "1. Print the rectangle\n" +
            "2. Print the square triangle\n" +
            "3. Print isosceles triangle\n" +
            "4. Exit"
        );
        System.out.print("Your choice is: ");
        int numSelection = Integer.parseInt(scanner.nextLine());
        switch (numSelection) {
            case 1:
                drawRectangle();
                break;
            case 2:
                drawRightTriangle();
                break;
            case 3:
                drawIsoscelesTriangle();
                break;
            case 4:
                System.out.println("You have successfully exited.");
                break;
            default:
                System.out.println("You entered the wrong choice.");
        }
    }
    public static void drawRectangle() {
        System.out.println("Enter length of rectangle: ");
        int lengthRec = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter width of rectangle: ");
        int widthRec = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<=widthRec; i++) {
            for (int j=0; j<=lengthRec; j++) {
                System.out.print(" * ");
            }
            System.out.print("\n");
        }
    }
    public static void drawRightTriangle() {
        System.out.println(
            "The corner is square at 4 different angles:\n" +
            "1. Top-left\n" + "2. Top-right\n" +
            "3. Bottom-left\n" + "4. Bottom-right\n"
        );
        System.out.print("Enter the selection number as above: ");
        int cornerNumSelection = Integer.parseInt(scanner.nextLine());
        switch (cornerNumSelection) {
            case 1:
                for(int i=5; i>=1; i--) {
                    for (int j=0; j<i; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 2:
                for(int i=0; i<5; i++) {
                    for (int j=0; j<i; j++){
                        System.out.print(" ");
                    }
                    for (int k=5; k>i; k--) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 3:
                for(int i=1; i<=5; i++) {
                    for(int j=0; j<i; j++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
            case 4:
                for (int i=1; i<=5; i++) {
                    for (int j=5; j>i; j--) {
                        System.out.print(" ");
                    }
                    for (int k=0; k<i; k++) {
                        System.out.print("*");
                    }
                    System.out.print("\n");
                }
                break;
        }
    }
    public static void drawIsoscelesTriangle() {
        for (int i=9; i>0; i-=2) {
            for (int j=0; j<i/2; j++) {
                System.out.print(" ");
            }
            for (int k=9; k>=i; k--) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
