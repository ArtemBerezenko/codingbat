package com.company.Leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        Set<Integer> set = new HashSet<>();

        int l = prices.length;
        while (l > 0) {
            l = maximizeProfit(prices, set, l);
        }
        return Collections.max(set);
    }

    private static int maximizeProfit(int[] prices, Set<Integer> set, int l) {
        int min = 0;
        for (int i = 1; i < l; i++) {
            if (prices[i] < prices[min]) {
                min = i;
            }
        }

        int max = min;
        for (int i = min + 1; i < l; i++) {
            if (prices[i] > prices[max]) {
                max = i;
            }
        }
        set.add(prices[max] - prices[min]);
        return min;
    }

    public static int maxProfitOnePass(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitOnePass(new int[]{2, 3, 6, 1, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(maxProfit(new int[]{2, 4, 1}));

    }
}
