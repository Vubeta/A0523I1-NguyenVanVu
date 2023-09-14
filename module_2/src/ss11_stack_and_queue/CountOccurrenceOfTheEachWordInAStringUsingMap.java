package ss11_stack_and_queue;

import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurrenceOfTheEachWordInAStringUsingMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Integer> wordsTreeMap = new TreeMap<>();

        System.out.println("Enter the string here: ");
        String userString = scanner.nextLine();
        String newString = userString.toLowerCase();
        String[] words = newString.split("\\s+");
        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "");
            if (wordsTreeMap.containsKey(word)) {
                wordsTreeMap.put(word, wordsTreeMap.get(word) + 1);
            } else {
                wordsTreeMap.put(word, 1);
            }
        }
        System.out.println(wordsTreeMap);
    }
}
