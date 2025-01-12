package com.company;

import java.util.HashMap;
import java.util.Map;

public class ConstructKPalindromeStrings {
    public static boolean canConstruct(String s, int k) {
        if (s.length() < k) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 1) + 1);
        }

        int oddCount = 0;
        for (Integer i : map.values()) {
            if (i % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= k;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("annabelle", 2));
    }
}
