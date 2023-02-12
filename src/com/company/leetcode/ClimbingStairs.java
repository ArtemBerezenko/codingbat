package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static int climbStairs(int n) {
        return climb(new HashMap<>(), n);
    }

    private static int climb(Map<Integer, Integer> map, int n) {
        if (map.containsKey(n))
            return map.get(n);
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int acc = climb(map, n - 2) + climb(map, n - 1);
        map.put(n, acc);
        return acc;
    }

    public static int climbStairsWithTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            if (i == 1)
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(37)); //39088169
        System.out.println(climbStairsWithTabulation(37)); //39088169

    }
}
