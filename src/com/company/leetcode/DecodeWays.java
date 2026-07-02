package com.company.leetcode;

public class DecodeWays {
    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (i >= 2) {
                int digit = Integer.parseInt(String.valueOf(s.charAt(i - 2)).concat(String.valueOf(s.charAt(i - 1))));
                if (digit >= 10 && digit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("226"));
    }
}
