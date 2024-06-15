package com.company.leetcode;

import java.util.Arrays;

public class MinimumAdjacentSwapsToMakeValidArray {
    public static int minimumSwaps(int[] nums) {
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sorted[0]) {
                min = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == sorted[sorted.length - 1]) {
                max = i;
                break;
            }
        }

        return (nums.length - 1 - max) + min - (min > max ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{3,26,27,28,20,23,31,3,34,8,39,36,29,19,24,24,18,3,31,24}));
    }
}
