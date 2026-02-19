package com.company.leetcode;

public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        int l = 0;
        int r = 1;
        int sum = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                r++;
            } else {
                sum += Math.min(l, r);
                l = r;
                r = 1;
            }
        }
        sum += Math.min(l, r);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }
}
