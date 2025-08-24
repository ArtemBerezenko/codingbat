package com.company.leetcode;

public class LongestSubarrayOf1sAfterDeletingOneElement {
    public static int longestSubarray(int[] nums) {
        int l = 0;
        int zero = 0;
        int max = 0;

        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zero++;
            }

            while (zero > 1) {
                if (nums[l] == 0) {
                    zero--;
                }
                l++;
            }

            max = Math.max(max, r - l);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[] {0,1,1,1,0,1,1,0,1}));
    }
}
