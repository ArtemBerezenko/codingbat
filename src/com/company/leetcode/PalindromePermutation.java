package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class PalindromePermutation {

    public static boolean canPermutePalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        int sum = 0;
        Set<String> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            String value = String.valueOf(c);
            if (set.contains(value)) {
                sum += 2;
                set.remove(value);
            } else {
                set.add(value);
            }
        }

        if (set.size() > 1) {
            return false;
        }

        return sum > 0;
    }

    public static boolean canPermutePalindromeSimple(String s) {
        Set<String> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            String value = String.valueOf(c);
            if (!set.contains(value)) {
                set.add(value);
            } else {
                set.remove(value);
            }
        }

        return set.isEmpty() || set.size() == 1;
    }

    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("aabc"));
    }
}
