package ss11_stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

public class CheckBracketInEquationUsingStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the equation include bracket here: ");
        String userString = scanner.nextLine();
        if(checkBracket(userString)){
            System.out.println("Well");
        } else {
            System.out.println("???");
        }

    }

    private static boolean checkBracket(String userString){
        Stack<Character> bStack = new Stack<>();
        for (char sym : userString.toCharArray()) {
            if(sym == '(') {
                bStack.push(sym);
            } else if (sym== ')') {
                if(bStack.isEmpty()) {
                    return false;
                }
                char left = bStack.pop();
                if (left == sym) {
                    return false;
                }
            }
        }
        if (bStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
