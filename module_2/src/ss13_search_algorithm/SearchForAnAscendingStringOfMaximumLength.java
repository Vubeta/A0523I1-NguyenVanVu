package ss13_search_algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchForAnAscendingStringOfMaximumLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Character> arr = new LinkedList<>();
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();
        for (int i = 0; i < userInput.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(userInput.charAt(i));
            for (int j = i+1; j < userInput.length(); j++) {
                if (userInput.charAt(j)>list.getLast()) {
                    list.add(userInput.charAt(j));
                }
            }
            if(list.size()>arr.size()) {
                arr.clear();
                arr.addAll(list);
            }
            list.clear();
        }
        for (char c : arr) {
            System.out.print(c);
        }
    }
}
