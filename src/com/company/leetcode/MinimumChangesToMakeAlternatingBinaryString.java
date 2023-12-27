package com.company.leetcode;

public class MinimumChangesToMakeAlternatingBinaryString {
    
    public static int minOperations(String s) {
        int start0 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '1') {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '0') {
                    start0++;
                }
            }
        }

        return Math.min(start0, s.length() - start0);
    }


    public static void main(String[] args) {
        System.out.println(minOperations("110010"));
    }
}
