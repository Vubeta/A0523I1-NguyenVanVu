package ss12_java_collection_framework.excercise_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOccurrenceOfTheEachInAStringUsingMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> newList = new HashMap<>();
        System.out.println("Enter the string here: ");
        String userString = scanner.nextLine();
        String newString = userString.toLowerCase();
        String[] words = newString.split(" ");

        for (String word : words) {
            if(!newList.containsKey(word)) {
                newList.put(word,1);
            } else {
                newList.replace(word, newList.get(word)+1);
            }
        }
        System.out.println(newList);
    }
}
