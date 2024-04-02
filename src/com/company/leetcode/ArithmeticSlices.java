package com.company.leetcode;

public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1,2,3,4}));
    }

}
