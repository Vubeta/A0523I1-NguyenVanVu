package ss1_introduce_to_java;

import java.util.Scanner;

public class bai3_ung_dung_chuyen_doi_tien_te {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền USD tại đây: ");
        double dollarNum = Double.parseDouble(scanner.nextLine());
        System.out.println("Giá trị VNĐ là: " + dollarNum*23000);
    }
}
