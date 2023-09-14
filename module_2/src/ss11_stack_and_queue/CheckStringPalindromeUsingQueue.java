package ss11_stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class CheckStringPalindromeUsingQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Character> newStack = new Stack<>();
        Queue<Character> newQueue = new LinkedList<>();

        System.out.println("Enter the string here: ");
        String userString = scanner.nextLine();
        String newString = userString.replaceAll("\\s", "").toLowerCase();

        for (char c : newString.toCharArray()) {
            newStack.push(c);
            newQueue.add(c);
        }

        boolean isPalindrome = true;
        while (!newStack.isEmpty() && !newQueue.isEmpty()) {
            if (newStack.pop() != newQueue.poll()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("This string is a palindrome string");
        } else {
            System.out.println("This string is not a palindrome string");
        }
    }
}
