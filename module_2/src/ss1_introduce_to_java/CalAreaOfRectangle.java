package ss1_introduce_to_java;

import java.util.Scanner;

public class CalAreaOfRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float width, height;
        System.out.print("Enter width: ");
        width = scanner.nextFloat();
        System.out.print("Enter height: ");
        height = scanner.nextFloat();
        System.out.print("Area is: " + width*height);
    }
}