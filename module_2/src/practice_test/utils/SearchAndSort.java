package practice_test.utils;

public class SearchAndSort {
    //Tìm kiếm tuyến tính
    public static int linearSearch(int[] array, int value) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]){
                index = i;
                break;
            }
        }
        return index;
    }

    //Tìm kiếm nhị phân
    public static int binarySearch(int[] array, int value) {
        int left = array[0];
        int right = array[array.length-1];
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

    //Sắp xếp nổi bọt
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--)
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
        }
    }

    //Sắp xếp chọn
    public static void selectionSort(int[] array) {
        int min; // chỉ số phần tử nhỏ nhất trong dãy hiện hành
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j; // ghi nhận vị trí phần tử nhỏ nhất
            if (min != i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }

    //Sắp xếp chèn
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }
}
