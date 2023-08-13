package ss3_array_and_method_in_java;

import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int sizeArr = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[sizeArr];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter the integer number for index " + i + " of array: ");
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        int minNum = arr[0];

        for (int element: arr) {
            if(element<minNum) {
                minNum = element;
            }
        }
        System.out.print("\nThe min value in array is " + minNum);
    }
}
