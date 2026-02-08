package com.company.leetcode;

public class MinimumDeletionsToMakeStringBalanced {

    public static int minimumDeletions(String s) {
        int bCount = 0;
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                min = Math.min(min + 1, bCount);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));
    }
}
