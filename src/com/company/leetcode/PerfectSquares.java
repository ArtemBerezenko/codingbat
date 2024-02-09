package com.company.leetcode;

import java.util.Arrays;

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSquareIndex = (int) Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquareIndex];
        
        for (int i = 1; i < maxSquareIndex; i++) {
            squareNums[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < maxSquareIndex; j++) {
                if (i >= squareNums[j]) {
                    dp[i] = Math.min(dp[i], dp[i - squareNums[j]] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(43));
    }
}
