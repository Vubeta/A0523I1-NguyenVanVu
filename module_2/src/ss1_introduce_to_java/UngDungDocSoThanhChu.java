package ss1_introduce_to_java;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số đo chiều cao cần đọc: ");
        int heightNum = Integer.parseInt(scanner.nextLine());

        if (heightNum<0 || heightNum>999) {
            System.out.println("out of ability");
        } else if (heightNum<10) {
            System.out.println(convertOnestoWords(heightNum));
        } else if (heightNum<20) {
            System.out.println(convertTeenstoWords(heightNum));
        } else if (heightNum<100) {
            System.out.println(convertTenstoWords(heightNum/10) + " " + convertOnestoWords(heightNum%10));
        } else {
            if ((heightNum%100)/10 == 1) {
                System.out.println(convertOnestoWords(heightNum/100) + " hundred and "
                                                        + convertTeenstoWords(heightNum%100));
            } else {
                System.out.println(convertOnestoWords(heightNum/100) + " hundred and "
                                                        + convertTenstoWords((heightNum%100)/10) + " "
                                                        + convertOnestoWords(heightNum%10));
            }
        }
    }
//    lấy số hàng trăm: heightNum/100
//    lấy số hàng chục: (heightNum%100)/10
//    lấy số hàng đơn vị: heightNum%10
    public static String convertOnestoWords(int number) {
        switch(number) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "";
        }
    }

    public static String convertTeenstoWords(int number) {
        switch(number) {
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 15: return "fifteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }

    public static String convertTenstoWords(int number) {
        switch(number) {
            case 2: return "twenty";
            case 3: return "thirty";
            case 4: return "forty";
            case 5: return "fifty";
            case 6: return "sixty";
            case 7: return "seventy";
            case 8: return "eighty";
            case 9: return "ninety";
            default: return "";
        }
    }
}
