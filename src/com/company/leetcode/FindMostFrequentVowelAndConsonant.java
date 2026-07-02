package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindMostFrequentVowelAndConsonant {
    public static int maxFreqSum(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int vowel = map.entrySet().stream()
                .filter(e -> vowels.contains(e.getKey()))
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);

        int consonant = map.entrySet().stream()
                .filter(e -> !vowels.contains(e.getKey()))
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .orElse(0);
        return vowel + consonant;
    }

    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes"));
    }
}
