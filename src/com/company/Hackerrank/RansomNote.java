package com.company.Hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        noteMap = new HashMap<>();
        fillHashMap(magazineMap, magazine);
        fillHashMap(noteMap, note);
    }

    private static void countWordsInHashMap(Map<String, Integer> map, String str) {
       if (map.containsKey(str)) {
           int count = map.get(str);
           map.put(str, ++count);
       } else {
           map.put(str, 0);
       }
    }

    private static void fillHashMap(Map<String, Integer> map, String string) {
        String word = "";
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (symbol == ' ' && i != string.length() - 1) {
                countWordsInHashMap(map, word);
                word = "";
            } else if (i == string.length() - 1) {
                word += symbol;
                countWordsInHashMap(map, word);
            }else {
                word += symbol;
            }
        }
    }

    public boolean solve() {
        boolean isReplicate = false;
        for (String word : noteMap.keySet()) {
            if (magazineMap.containsKey(word)) {
                int value = magazineMap.get(word);
                if (value >= noteMap.get(word)) {
                    isReplicate = true;
                } else {
                    return false;
                }
            }
        }
        return isReplicate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}