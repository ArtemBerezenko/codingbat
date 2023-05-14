package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] st = t.toCharArray();

        int i = 0;
        int l = 0;

        while (l < t.length() && i < s.length()) {
            if (st[l] == sc[i]) {
                i++;
            }
            l++;
        }
        return i == s.length();
    }

    public static boolean isSubsequenceDP(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        int[] prev = new int[s.length() + 1];

        for (int i = t.length() - 1; i >= 0; i--) {
            int[] cur = new int[s.length() + 1];
            for (int j = s.length() - 1; j >= 0; j--) {
                if (t.charAt(i) == s.charAt(j)) {
                    cur[j] = 1 + prev[j + 1];
                } else {
                    cur[j] = Math.max(prev[j], cur[j + 1]);
                }
            }
            prev = cur;
        }
        return prev[0] == s.length();
    }

    public static boolean isSubsequenceRecursion(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        if (s.charAt(0) == t.charAt(0)) {
            s = s.substring(1);
        }
        t = t.substring(1);

        return isSubsequenceRecursion(s, t);
    }

    public static boolean isSubsequenceHashMap(String s, String t) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(i);

        }

        int index = -1;
        for (Character ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            boolean isMatch = false;
            for (Integer i : map.get(ch)) {
                if (index < i) {
                    index = i;
                    isMatch = true;
                    break;
                }
            }
            if (!isMatch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSubsequenceHashMap("ab", "baab"));
    }
}
