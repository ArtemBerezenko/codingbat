package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    static Map<String, List<String>> map = Map.of(
            "2", List.of("a", "b", "c"),
            "3", List.of("d", "e", "f"),
            "4", List.of("g", "h", "i"),
            "5", List.of("j", "k", "l"),
            "6", List.of("m", "n", "o"),
            "7", List.of("p", "q", "r", "s"),
            "8", List.of("t", "u", "v"),
            "9", List.of("w", "x", "y", "z"));

    public static List<String> letterCombinations(String digits) {
        char[] charArray = digits.toCharArray();
        List<List<String>> source = new ArrayList<>();
        for (char c : charArray) {
            String number = Character.toString(c);
            source.add(map.get(number));
        }
        List<String> target = new ArrayList<>();

        if (!source.isEmpty()) {
            return letterCombinations(new ArrayList<>(), "", source);
        }
        return target;
    }

    private static List<String> letterCombinations(List<String> acc, String combination, List<List<String>> tail) {
        if (!tail.isEmpty()) {
            List<String> head = tail.get(0);
            for (String i : head) {
                letterCombinations(acc, combination.concat(i), tail.subList(1, tail.size()));
            }
        } else {
            acc.add(combination);
        }
        return acc;
    }

    public static void main(String[] args) {
        System.out.print(letterCombinations("234"));
    }
}
