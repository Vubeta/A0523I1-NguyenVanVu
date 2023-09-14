package ss11_stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class ConvertFromDecimalToBinary {
    public static void main(String[] args) {
        Stack<Integer> newStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);

        int decimalNum = 0;
        do {
            System.out.print("Enter a number here: ");
            decimalNum = scanner.nextInt();
        } while (decimalNum > 0);

        String result = "";
        while (decimalNum > 0) {
            int remainder = decimalNum % 2;
            decimalNum /= 2;
            newStack.push(remainder);
        }

        while (!newStack.isEmpty()) {
            int value = newStack.pop();
            result += value;
        }

        System.out.println(result);
    }
}