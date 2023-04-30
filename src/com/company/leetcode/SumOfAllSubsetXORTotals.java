package com.company.leetcode;

public class SumOfAllSubsetXORTotals {

    public static int subsetXORSum(int[] nums) {
        return getNextXors(0, 0, nums);
    }

    private static int getNextXors(int acc, int i, int[] nums) {
        if (i == nums.length) {
            return acc;
        }
        return getNextXors(acc, i + 1, nums) + getNextXors(nums[i] ^ acc, i + 1, nums);
    }

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
}
