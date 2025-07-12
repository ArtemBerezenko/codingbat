package com.company.leetcode;

public class PaintHouse {
    public static int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        for (int n = costs.length - 2; n >= 0; n--) {
            costs[n][0] += Math.min(costs[n + 1][1], costs[n + 1][2]);
            costs[n][1] += Math.min(costs[n + 1][0], costs[n + 1][2]);
            costs[n][2] += Math.min(costs[n + 1][0], costs[n + 1][1]);
        }

        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }

    public static void main(String[] args) {
        System.out.println(minCost(new int[][]{
//                {7,6,2}
                {17,2,17},
                {16,16,5},
                {14,3,19}
        }));
    }
}
