package com.company.leetcode;

public class HouseRobberII {
    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        Integer[] memo1 = new Integer[nums.length];
        Integer[] memo2 = new Integer[nums.length];
        return Math.max(
                rob(0, nums, nums.length - 2, memo1),
                rob(1, nums, nums.length - 1, memo2)
        );
    }

    private static int rob(int i, int[] nums, int end, Integer[] memo) {
        if (i > end) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }
        memo[i] =  Math.max(
                rob(i + 1, nums, end, memo),
                nums[i] + rob(i + 2, nums, end, memo)
        );
        return memo[i];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,3,2}));
    }
}
