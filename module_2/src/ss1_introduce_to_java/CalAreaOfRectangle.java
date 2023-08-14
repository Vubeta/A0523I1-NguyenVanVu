package ss1_introduce_to_java;

import java.util.Scanner;

public class CalAreaOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float width, height;
        System.out.print("Enter width: ");
        width = Float.parseFloat(scanner.nextLine());
        System.out.print("Enter height: ");
        height = Float.parseFloat(scanner.nextLine());
        System.out.print("Area is: " + width*height);
    }
}