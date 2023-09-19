package ss13_search_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class SetupAlgorithmBinarySearchUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] listInteger = new int[7];
        //input
        for (int i = 0; i < listInteger.length; i++) {
            System.out.print("Enter the integer number [" + i + "]: ");
            listInteger[i] = Integer.parseInt(scanner.nextLine());
        }
        //sort
        for (int i = 1; i < listInteger.length; i++) {
            int temp = listInteger[i];
            int pos = i;
            while (pos > 0 && temp < listInteger[pos - 1]) {
                listInteger[pos] = listInteger[pos - 1];
                pos--;
            }
            listInteger[pos] = temp;
        }
        System.out.println("Array after sorting is " + Arrays.toString(listInteger));
        //binary search
        System.out.print("Enter the integer number which you want to search: ");
        int userInput = Integer.parseInt(scanner.nextLine());
        int index = binarySearch(listInteger, 0, listInteger.length - 1, userInput);
        System.out.println("Index of value (" + userInput + ") is " + index);
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        do {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (value > array[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        } while (left <= right);
        return -1;
    }
}
