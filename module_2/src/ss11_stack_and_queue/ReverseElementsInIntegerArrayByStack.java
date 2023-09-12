package ss11_stack_and_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ReverseElementsInIntegerArrayByStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> newStack1 = new Stack<>();
        Stack<String> newStack2 = new Stack<>();

        //Reverse Integer Array By Stack
        System.out.print("Enter the count elements of the integer array: ");
        int countElements = Integer.parseInt(scanner.nextLine());
        ArrayList<Integer> integerArrayList = new ArrayList<>(countElements);

        for (int i = 0; i < countElements; i++) {
            System.out.print("Enter the integer value [" + i + "]: ");
            int numInt = Integer.parseInt(scanner.nextLine());
            integerArrayList.add(i, numInt);
        }

        System.out.println("The original array includes: " + integerArrayList);

        for (int i = 0; i < countElements; i++) {
            newStack1.push(integerArrayList.get(i));
        }
        integerArrayList.clear();
        for (int i = 0; i < countElements; i++) {
            integerArrayList.add(i, newStack1.pop());
        }

        System.out.println("The reversed integer array includes: " + integerArrayList);

        //Reverse String Array By Stack
        System.out.print("Enter the string value: ");
        String stringUser = scanner.nextLine();
        String[] stringArrayList = stringUser.split(" ");

        for (String element : stringArrayList) {
            newStack2.push(element);
        }
        for (int i = 0; i < stringArrayList.length; i++) {
            stringArrayList[i] = newStack2.pop();
        }
        stringUser = String.join(" ", stringArrayList);

        System.out.println("The reversed string is: " + stringUser);
    }
}
