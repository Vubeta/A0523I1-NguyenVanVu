package ss14_sort_algorithm;

import java.util.Arrays;

public class IllustratesInsertionSortAlgorithm {
    public static void main(String[] args) {
        int[] arrNum = {3, 6, 11, 17, 5, 2};
        System.out.println("The array inclues: " + Arrays.toString(arrNum));

        for (int i = 1; i < arrNum.length; i++) {
            int temp = arrNum[i];
            int pos = i;
            System.out.println("With index = " + i + " we have tempValue = " +
                    temp + " and position = " + pos + ":");
            while (pos > 0 && temp < arrNum[pos - 1]) {
                System.out.println("- Because tempValue < array[" + (pos - 1) +
                        "] means " + temp + " < " + arrNum[pos - 1] +
                        " so we assign array[" + pos + "] = array[" + (pos - 1) + "] = " + arrNum[pos - 1]);
                arrNum[pos] = arrNum[pos - 1];
                pos--;
            }
            arrNum[pos] = temp;
            System.out.println("- We assign array[" + pos + "] = " + temp);
        }
    }
}
