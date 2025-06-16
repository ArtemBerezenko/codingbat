package com.company.leetcode;

public class MaximumDifferenceBetweenIncreasingElements {
    public static int maximumDifference(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                if (diff > 0 && diff > max) {
                    max = diff;
                }
            }
        }
        return max == Integer.MIN_VALUE ? -1 : max;
    }

    public static int maximumDifferenceSOLUTION(int[] nums) {
        int result = -1;
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                result = Math.max(result, nums[i] - min);
            } else {
                min = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumDifference(new int[]{7,1,5,4}));
    }
}
