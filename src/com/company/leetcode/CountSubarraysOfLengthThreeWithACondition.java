package com.company.leetcode;

public class CountSubarraysOfLengthThreeWithACondition {
    public static int countSubarrays(int[] nums) {
        int l = 0;
        int r = 2;

        int result = 0;
        while (r < nums.length) {
            if (Math.abs(nums[l] + nums[r]) == Math.abs(nums[l + 1]) / 2) {
                result++;
            }
            l++;
            r++;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {1,2,1,4,1}));
    }
}
