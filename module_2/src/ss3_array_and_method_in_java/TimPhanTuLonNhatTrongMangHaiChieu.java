package ss3_array_and_method_in_java;

import java.util.Scanner;

public class TimPhanTuLonNhatTrongMangHaiChieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
//        float[][] arr = {{3.3f,4.7f,7.6f},{4.9f,5.5f,9.3f}};
        float maxValue = arr[0][0];
        int indexRow=0, indexCol=0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.println("\nMax value is " + maxValue + " with its index is [" + indexRow + "][" + indexCol + "]");
    }
}
