package ss14_sort_algorithm;

import java.util.Arrays;

public class SetupInsertionSortAlgorithm {
    public static void main(String[] args) {
        int[] arrNum = {3, 6, 11, 17, 5, 2};
        System.out.println("The array inclues: " + Arrays.toString(arrNum));
        System.out.println("The array after insertion sort inclues: " +
                Arrays.toString(insertionSort(arrNum)));
    }

    public static int[] insertionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int temp = list[i];
            int pos = i;
            while (pos > 0 && temp < list[pos - 1]) {
                list[pos] = list[pos - 1];
                pos--;
            }
            list[pos] = temp;
        }
        return list;
    }
}
