package com.company.leetcode;

public class RunningSumOf1dArray {
    public static int[] runningSum(int[] nums) {
        if (nums.length <= 1) return nums;

        int[] result = new int[nums.length];
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(runningSum(new int[] {1,2,3,4}));
    }
}
