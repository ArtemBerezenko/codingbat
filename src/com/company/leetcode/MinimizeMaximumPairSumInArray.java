package com.company.leetcode;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int max = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            max = Math.max(max, nums[i] + nums[nums.length - 1 - i]);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(minPairSum(new int[]{4,1,5,1,2,5,1,5,5,4}));
    }
}
