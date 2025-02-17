package com.company.leetcode;

public class BestTimeToBuyAndSellStockWithCooldown {

    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length + 2];

        for (int i = prices.length - 1; i >= 0; i--) {
            int C1 = 0;
            for (int j = i + 1; j < prices.length; j++) {
                int profit = (prices[j] - prices[i]) + dp[j + 2];
                C1 = Math.max(profit, C1);
            }

            int C2 = dp[i + 1];

            dp[i] = Math.max(C1, C2);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,0,2}));
    }
}
