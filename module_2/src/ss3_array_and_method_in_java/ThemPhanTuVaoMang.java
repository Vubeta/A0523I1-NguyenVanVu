package ss3_array_and_method_in_java;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {10,4,6,7,8,0,0,0,0,0};
        System.out.println("Original array includes: ");
        for (int element: arr) {
            System.out.print(element + " ");
        }
        System.out.println("");
        System.out.print("Enter the number which you want to insert into array: ");
        int numInput = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter the index of number which you want to insert into array: ");
        int indexInput = Integer.parseInt(scanner.nextLine());

        if(indexInput<0 || indexInput>arr.length-1) {
            System.out.println("Couldn't insert the element which you entered above");
        } else {
            for (int i=0; i<arr.length; i++) {
                if(i == indexInput) {
                    for (int j=arr.length-1; j>i; j--) {
                        arr[j] = arr[j-1];
                    }
                    arr[i] = numInput;
                }
            }
            System.out.println("Array after inserting element includes: ");
            for (int element: arr) {
                System.out.print(element + " ");
            }
        }
    }
}
