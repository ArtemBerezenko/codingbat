package com.company.leetcode;

public class LongestBinarySubsequenceLessThanOrEqualToK {
    public static int longestSubsequence(String s, int k) {
        int sum = 0;
        int count = 0;
        int bitsLength = (int) (Math.log(k) / Math.log(2)) + 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(s.length() - 1 - i);
            if (ch == '1') {
                if (i < bitsLength && sum + (1 << i) <= k) {
                    sum += 1 << i;
                    count++;
                }
            } else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));
    }
}
