package com.company.leetcode;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i + k - 1 < nums.length; i++) {
            min = Math.min(min, nums[i + k - 1] - nums[i]);
        }
        return min;
     }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{9,4,1,7}, 2));
    }
}
