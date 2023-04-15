package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.computeIfPresent(String.valueOf(c), (k, v) -> v + 1);
            map.putIfAbsent(String.valueOf(c), 1);
        }

        if (map.size() == 1) {
            return map.values().stream().reduce(0, Integer::sum);
        }

        int sum = map.values().stream()
                .filter(v -> v > 1)
                .map(v -> {
                    if (v % 2 != 0) {
                        v -= 1;
                    }
                    return v;
                })
                .reduce(0, Integer::sum);

        if (sum % 2 == 0) {
            boolean containsOdd = map.values().stream().anyMatch(v -> v % 2 != 0);
            if (map.containsValue(1) || containsOdd) {
                sum++;
            }
        }
        return sum;
    }

    public static int longestPalindromeHashSet(String s) {
        Set<String> set = new HashSet<>();
        int sum = 0;
        for (char c : s.toCharArray()) {
            String value = String.valueOf(c);
            if (set.contains(value)) {
                sum += 2;
                set.remove(value);
            } else {
                set.add(value);
            }
        }

        if (!set.isEmpty()) {
            sum++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeHashSet("ababababa"));
    }

}
