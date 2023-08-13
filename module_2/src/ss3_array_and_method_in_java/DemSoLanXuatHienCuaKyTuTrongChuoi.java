package ss3_array_and_method_in_java;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string here: ");
        String strInput = scanner.nextLine();
        System.out.print("Enter the character which you want to count here: ");
        char charInput = scanner.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < strInput.length(); i++) {
            if(strInput.charAt(i) == charInput) {
                count++;
            }
        }
        System.out.println("The quantity of character '" + charInput + "' is " + count);
    }
}