package com.company.leetcode;

import java.util.Arrays;

public class CoinChangeII {
    static int[][] memo;

    public static int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return change(0, amount, coins);
    }

    private static int change(int i, int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }
        if (memo[i][amount] != -1) {
            return memo[i][amount];
        }
        if (coins[i] > amount) {
            return memo[i][amount] = change(i + 1, amount, coins);
        }
        return memo[i][amount] = change(i, amount - coins[i], coins) + change(i + 1, amount, coins);
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
    }
}
