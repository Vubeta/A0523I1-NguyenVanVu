package ss3_array_and_method_in_java;

import java.util.Scanner;

public class TinhTongCacSoODuongCheoChinhCuaMaTranVuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //create square matrix
        System.out.print("Enter the size of square matrix: ");
        int sizeArr = Integer.parseInt(scanner.nextLine());
        float[][] arr = new float[sizeArr][sizeArr];
        for (int i = 0; i < arr.length; i++) {
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

        //processing and outputting result
        float sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.print("Sum of numbers on the main diagonal of a square matrix: " + sum);
    }
}
