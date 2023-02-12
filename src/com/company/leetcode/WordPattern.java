package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern {

    public static boolean wordPattern(String pattern, String s) {
        List<String> words = Arrays.stream(s.split(" ")).toList();
        Map<String, String> patternMap = new HashMap<>();
        Map<String, String> wordsMap = new HashMap<>();

        if (pattern.length() != words.size()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            String symbol = pattern.substring(i, i + 1);
            String word = words.get(i);

            if (!patternMap.computeIfAbsent(symbol, k -> word).equals(word) || !wordsMap.computeIfAbsent(word, k -> symbol).equals(symbol)) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat dog"));
    }
}
