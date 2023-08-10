package ss2_loop_in_java;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the count number of integer: ");
        int countPrimeNumInput = Integer.parseInt(scanner.nextLine());
        int integerNum = 0;
        int countPrimeNum = 0;
        int[] arrPrimeNum = new int[countPrimeNumInput];
        do {
            if(checkPrimeNum(integerNum)) {
                arrPrimeNum[countPrimeNum] = integerNum;
                countPrimeNum++;
            }
            integerNum++;
        } while (countPrimeNum<countPrimeNumInput);
        for (int primeNum: arrPrimeNum) {
            System.out.print(primeNum + " ");
        }
    }
    public static boolean checkPrimeNum(int number) {
        if (number<2) {
            return false;
        }
        for (int i=2; i<=Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
