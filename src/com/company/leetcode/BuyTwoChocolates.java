package com.company.leetcode;

import java.util.Arrays;

public class BuyTwoChocolates {
    public static int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int sum = prices[0] + prices[1];
        int result = money - sum;

        return result >=0 ? result : money; 
    }
    
    public static void main(String[] args) {
        System.out.println(buyChoco(new int[] {1,2,2}, 3));
    }

}
