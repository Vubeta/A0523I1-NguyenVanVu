package ss1_introduce_to_java;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        System.out.print("Enter a non-negative integer up to 3 digits: ");
        int num = scanner.nextInt();

        if (num < 0 || num > 999) {
            System.out.println("Number is out of range.");
        } else if (num == 0) {
            System.out.println("zero");
        } else {
            String result = "";

            int hundreds = num / 100;
            int tensDigit = (num % 100) / 10;
            int onesDigit = num % 10;

            if (hundreds > 0) {
                result += ones[hundreds] + " hundred";
                if (tensDigit > 0 || onesDigit > 0) {
                    result += " and ";
                }
            }

            if (tensDigit == 1 && onesDigit > 0) {
                result += teens[onesDigit];
            } else {
                result += tens[tensDigit];
                if (tensDigit > 0 && onesDigit > 0) {
                    result += "-";
                }
                result += ones[onesDigit];
            }

            System.out.println(result);
        }

        scanner.close();
    }
}