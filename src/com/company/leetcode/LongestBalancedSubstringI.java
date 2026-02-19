package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubstringI {
    public static int longestBalanced(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = 1;
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            int pr = map.get(s.charAt(i - 1));
            int c = map.get(s.charAt(i));
            if (pr == c) {
                length++;
            } else {
                if (length > maxLength) {
                    maxLength = length;
                }
                length = 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestBalanced("zzabccy"));
    }
}
