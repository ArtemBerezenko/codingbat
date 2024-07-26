package com.company.leetcode;

public class LexicographicallySmallestPalindrome {
    public static String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                if (sb.charAt(l) > sb.charAt(r)) {
                    sb.setCharAt(l, sb.charAt(r));
                } else {
                    sb.setCharAt(r, sb.charAt(l));
                }
            }
            l++;
            r--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeSmallestPalindrome("egcfe"));
    }
}
