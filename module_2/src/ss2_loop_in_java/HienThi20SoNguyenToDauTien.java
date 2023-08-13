package ss2_loop_in_java;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the quantity of first prime numbers: ");
        int numbers = Integer.parseInt(scanner.nextLine());
        int n = 0;
        int count = 0;
        int[] arrPrimeNum = new int[numbers];
        do {
            if(checkPrimeNum(n)) {
                arrPrimeNum[count] = n;
                count++;
            }
            n++;
        } while (count<numbers);
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
