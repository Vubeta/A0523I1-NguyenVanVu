package ss2_loop_in_java;

import java.util.Scanner;

public class GreatestCommonFactor {
    public static void main(String[] args) {
        int a, b, temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();

        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 && b == 0) {
            System.out.println("No greatest common factor");
        } else {
            System.out.print("Greatest common factor between " + a + " and " + b + " is ");
            while(b!=0) {
                temp = b;
                b = a%b;
                a = temp;
            }
            System.out.print(a);
        }
    }
}
