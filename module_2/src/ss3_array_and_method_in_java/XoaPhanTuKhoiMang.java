package ss3_array_and_method_in_java;

import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10,4,6,7,8,6,0,0,0,0};
        System.out.println("Original array includes: ");
        for (int element: arr) {
            System.out.print(element + " ");
        }
        System.out.println("");
        System.out.print("Enter the element which you want to delete: ");
        int x = Integer.parseInt(scanner.nextLine());
        for (int i=0; i<arr.length; i++) {
            if(arr[i] == x) {
                for (int j=i; j<arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = 0;
            }
        }
        System.out.println("Array after deleting element includes: ");
        for (int element: arr) {
            System.out.print(element + " ");
        }
    }
}
