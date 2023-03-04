package com.company.leetcode;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        }

        int[] array = new int[cost.length];
        array[0] = cost[0];
        array[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            array[i] = Math.min(array[i - 1], array[i - 2]) + cost[i];
        }

        return Math.min(array[cost.length - 1], array[cost.length - 2]);
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
    }
}
