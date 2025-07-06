package com.company.leetcode;

import java.util.Arrays;

public class MaximumNumberOfConsecutiveValuesYouCanMake {
    public static int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int sum = 1;

        for (int i = 0; i < coins.length; i++) {
            if (sum < coins[i]) {
                break;
            }
            sum += coins[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getMaximumConsecutive(new int[] {1,1,1,4}));
    }
}
