package com.company.leetcode;

public class BestTimeToBuyAndSellStockIV {
    private static int[] prices;
    private static int[][][] memo;

    public static int maxProfit(int k, int[] prices) {
        BestTimeToBuyAndSellStockIV.prices = prices;
        BestTimeToBuyAndSellStockIV.memo = new int[prices.length][k + 1][2];
        return dp(0, k, 0);
    }

    private static int dp(int i, int transactionsRemaining, int holding) {
        // Base cases
        if (transactionsRemaining == 0 || i == prices.length) {
            return 0;
        }

        if (memo[i][transactionsRemaining][holding] == 0) {
            int doNothing = dp(i + 1, transactionsRemaining, holding);
            int doSomething;

            if (holding == 1) {
                // Sell Stock
                doSomething = prices[i] + dp(i + 1, transactionsRemaining - 1, 0);
            } else {
                // Buy Stock
                doSomething = -prices[i] + dp(i + 1, transactionsRemaining, 1);
            }

            // Recurrence relation. Choose the most profitable option.
            memo[i][transactionsRemaining][holding] = Math.max(doNothing, doSomething);
        }

        return memo[i][transactionsRemaining][holding];
    }


    public static int maxProfit_Bottom_Up(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][k + 1][2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int transactionsRemaining = 1; transactionsRemaining <= k; transactionsRemaining++) {
                for (int holding = 0; holding < 2; holding++) {
                    int doNothing = dp[i + 1][transactionsRemaining][holding];
                    int doSomething;

                    if (holding == 1) {
                        doSomething = prices[i] + dp[i + 1][transactionsRemaining - 1][0];
                    } else {
                        doSomething = -prices[i] + dp[i + 1][transactionsRemaining][1];
                    }
                    dp[i][transactionsRemaining][holding] = Math.max(doNothing, doSomething);
                }
            }
        }
        return dp[0][k][0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[] {3,2,6,5,0,3}));
    }
}
