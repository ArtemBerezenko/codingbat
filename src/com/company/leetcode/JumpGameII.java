package com.company.leetcode;

import java.util.Arrays;

public class JumpGameII {

    public static int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return jump(nums, dp,0);
    }

    private static int jump(int[] nums, int[] dp, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int c = nums[i];
        int n = (int) 1e9;
        while (c > 0) {
            n = Math.min(jump(nums, dp, i + c) + 1, n);
            c--;
        }
        return dp[i] = n;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }
}
