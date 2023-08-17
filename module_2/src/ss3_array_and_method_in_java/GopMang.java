package ss3_array_and_method_in_java;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[3];
        int[] arr2 = new int[5];
        int[] arrFinal = new int[arr1.length + arr2.length];

        System.out.println("First array includes " + arr1.length + " element(s): ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print("Enter the value for index " + i + " of first array: ");
            arr1[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("\nSecond array includes " + arr2.length + " element(s): ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("Enter the value for index " + i + " of second array: ");
            arr2[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = 0; i < arrFinal.length; i++) {
            if (i < arr1.length) {
                arrFinal[i] = arr1[i];
            } else {
                arrFinal[i] = arr2[i - arr1.length];
            }
        }

        System.out.print("\nFirst array includes: ");
        for (int element : arr1) {
            System.out.print(element + " ");
        }
        System.out.print("\nSecond array includes: ");
        for (int element : arr2) {
            System.out.print(element + " ");
        }
        System.out.print("\nFinal array includes: ");
        for (int element : arrFinal) {
            System.out.print(element + " ");
        }
    }
}
