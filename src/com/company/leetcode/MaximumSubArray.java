package com.company.leetcode;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int i = 1; i < nums.length; i++) {
            currentSum += nums[i];
            if (maxSum < currentSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArrayTimeLimitExceeded(int[] nums) {
        int[] results = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int maxSum = nums[i];
            int currentSum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currentSum += nums[j];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                }
            }
            results[i] = maxSum;
        }

        int max = results[0];
        for (int i = 0; i < results.length; i++) {
            if (max < results[i]) {
                max = results[i];
            }
        }
        return max;
    }
}
