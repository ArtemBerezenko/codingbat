package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueLength3PalindromicSubsequences {
    public static int countPalindromicSubsequence(String s) {
        int result = 0;
        Set<Character> letters = new HashSet<>();

        for (Character c : s.toCharArray()) {
            letters.add(c);
        }

        for (Character c : letters) {
            Set<Character> set = new HashSet<>();
            int i = s.indexOf(c);
            int j = s.lastIndexOf(c);

            for (int k = i + 1; k < j; k++) {
                set.add(s.charAt(k));
            }
            result += set.size();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("bbcbaba"));
    }
}