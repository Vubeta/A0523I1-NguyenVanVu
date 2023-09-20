package ss13_search_algorithm;

import java.util.LinkedList;
import java.util.Scanner;

public class SearchForAdjacentStringOfMaximumLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string here: ");
        String userInput = scanner.nextLine();
//        String userInput = "abcabcdgabxy";
//        String userInput = "abcabcdgabmnsxy";
//        String userInput = "abcabcdgaAbmnsxy";
        LinkedList<Character> arr = new LinkedList<>();
        LinkedList<Character> tempArr = new LinkedList<>();

        for (int i = 0; i < userInput.length(); i++) {
            if (tempArr.isEmpty()) {
                tempArr.add(userInput.charAt(i));
            } else if (tempArr.getLast() <= userInput.charAt(i)) {
                tempArr.add(userInput.charAt(i));
                if (i < userInput.length() - 1) {
                    continue;
                }
            }

            if (arr.size() < tempArr.size()) {
                arr.clear();
                arr.addAll(tempArr);
            }
            tempArr.clear();
            tempArr.add(userInput.charAt(i));
        }

        for (char c : arr) {
            System.out.print(c);
        }
    }
}
