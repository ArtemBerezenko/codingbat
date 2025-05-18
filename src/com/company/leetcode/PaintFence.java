package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PaintFence {
    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int numWays(int n, int k) {
        return totalWays(n, k);
    }

    private static int totalWays(int i, int k) {
        if (i == 1) return k;
        if (i == 2) return k * k;

        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        memo.put(i, (k - 1) * (totalWays(i - 1, k) + totalWays(i - 2, k)));
        return memo.get(i);
    }


    public static int numWays2(int n, int k) {
        int[] dp = new int[n + 1];

        dp[0] = k;
        dp[1] = k * k;

        for (int i = 3; i <= n; i++) {
            dp[i] = (k - 1) * (dp[i - 1] + dp[i - 2]);
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numWays(3, 2));
    }
}
