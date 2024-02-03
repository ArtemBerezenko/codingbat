package com.company.leetcode;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);

        for (int start = N - 1; start >= 0; start--) {
            int currMax = 0;
            int end = Math.min(N, start + k);

            for (int i = start; i < end; i++) {
                currMax = Math.max(currMax, arr[i]);
                dp[start] = Math.max(dp[start], dp[i + 1] + currMax * (i - start + 1));
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(maxSumAfterPartitioning(new int[]{1,4,1,5,7,3,6,1,9,9,3}, 4));
    }
}
