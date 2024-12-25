package com.company.leetcode;

import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int[] result = prices.clone();

        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                result[stack.pop()] -= prices[i];
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(finalPrices(new int[] {8,4,6,2,3}));
    }
}
