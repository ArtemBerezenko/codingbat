package com.company.leetcode;

import java.util.Arrays;

public class CountTheNumberOfFairPairs {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums, upper + 1) - helper(nums, lower);
    }

    private static long helper(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        long result = 0;

        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum < target) {
                result += (r - l);
                l++;
            } else {
                r--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countFairPairs(new int[] {0,1,7,4,4,5}, 3, 6));
    }
}
