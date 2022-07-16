package com.company.Leetcode;

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

    public static void main(String[] args) {
        System.out.println(isSubsequence("acb", "ahbgdc"));
    }
}
