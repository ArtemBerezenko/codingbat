package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestFibonacciSubsequence {
    public static int lenLongestFibSubseq(int[] arr) {
        int maxLen = 0;
        int[][] dp = new int[arr.length][arr.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);

            for (int j = 0; j < i; j++) {
                int diff = arr[i] - arr[j];
                int prev = map.getOrDefault(diff, -1);

                if (diff < arr[j] && prev >= 0) {
                    dp[j][i] = dp[prev][j] + 1;
                } else {
                    dp[j][i] = 2;
                }

                maxLen = Math.max(maxLen, dp[j][i]);
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }

    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
    }
}
