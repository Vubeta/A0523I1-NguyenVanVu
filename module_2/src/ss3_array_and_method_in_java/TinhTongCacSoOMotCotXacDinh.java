package ss3_array_and_method_in_java;

import java.util.Scanner;

public class TinhTongCacSoOMotCotXacDinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create array two directions
        System.out.print("Enter the first size (rows) of array two directions: ");
        int rows = Integer.parseInt(scanner.nextLine());
        float[][] arr = new float[rows][];
        for (int i = 0; i < rows; i++) {
            System.out.print("Enter the second size (columns) of row " + i + ": ");
            int cols = Integer.parseInt(scanner.nextLine());
            arr[i] = new float[cols];
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Enter the number for [" + i + "][" + j + "]");
                arr[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }

        //show array
        System.out.println("Your array is: ");
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
                if (j < arr[i].length - 1) {
                    System.out.print(",");
                }
            }
            if (i < arr.length - 1) {
                System.out.print("],");
            } else {
                System.out.print("]");
            }
        }
        System.out.print("]");

        //input from user
        System.out.print("\nEnter the column number (index) which you want to calculate sum: ");
        int colIndex = Integer.parseInt(scanner.nextLine());

        //processing and outputting result
        float sum = 0;
        if (colIndex < 0 || colIndex >= arr.length) {
            System.out.print("\nThe column number (index) is not exist.");
        } else {
            for (float element : arr[colIndex]) {
                sum += element;
            }
        }
        System.out.print("\nSum of column " + colIndex + " is: " + sum);
    }
}
