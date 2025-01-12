package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
    private static Integer[] memo;

    public static int coinChangeTD(int[] coins, int amount) {
        CoinChange.memo = new Integer[amount + 1];
        return coinChangeHelper(coins, amount);
    }

    private static int coinChangeHelper(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }

        int minCost = Integer.MAX_VALUE;
        for (int coint : coins) {
            int res = coinChangeHelper(coins, amount - coint);
            if (res != -1) {
                minCost = Math.min(minCost, res + 1);
            }
        }
        memo[amount] = minCost == Integer.MAX_VALUE ? -1 : minCost;
        return memo[amount];
    }

    public int coinChangeBU(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    //greedy approach:
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) {
            return 0;
        }
        int index = coins.length - 1;

        List<Integer> list = new ArrayList<>();
        while (amount > 0) {
            if (index < 0) {
                return -1;
            }
            if (amount >= coins[index]) {
                int coin = coins[index];
                list.add(coin);
                amount -= coin;
            } else {
                index--;
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(coinChangeTD(new int[]{1, 2, 5}, 11));
//        System.out.println(coinChange1(new int[]{186, 419, 83, 408}, 6249));
    }

}
