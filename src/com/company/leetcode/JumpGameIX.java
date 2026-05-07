package com.company.leetcode;

public class JumpGameIX {
    public static int[] maxValue(int[] nums) {
        int[] ans = new int[nums.length];
        int[] prefixMax = new int[nums.length];
        prefixMax[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefixMax[i] = Math.max(nums[i - 1], nums[i]);
        }

        int sufixMin = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (prefixMax[i] > sufixMin) {
                ans[i] = ans[i + 1];
            } else {
                ans[i] = prefixMax[i];
            }
            sufixMin = Math.min(sufixMin, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{2,3,1}));
    }
}
