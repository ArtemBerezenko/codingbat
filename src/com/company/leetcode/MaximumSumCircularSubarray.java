package com.company.leetcode;

public class MaximumSumCircularSubarray {
    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];

        int maxEnd = nums[0];
        int maxSum = nums[0];

        int minEnd = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEnd = Math.max(nums[i], maxEnd + nums[i]);
            maxSum = Math.max(maxSum, maxEnd);

            minEnd = Math.min(nums[i], minEnd + nums[i]);
            minSum = Math.min(minSum, minEnd);

            totalSum += nums[i];
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }

    public static void main(String[] args) {
        System.out.println(maxSubarraySumCircular(new int[]{5,-3,5}));
    }
}
