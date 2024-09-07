package com.company.leetcode;

import java.util.Arrays;

public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int j = getMin(nums, i + 1, k - nums[i]);
            if (j != -1) {
                max = Math.max(max, nums[i] + nums[j]);
            }
        }

        return max;
    }

    private static Integer getMin(int[] nums, int start, int target) {
        int l = start;
        int r = nums.length - 1;

        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[r] < target) {
            return r;
        }
        if (nums[l] < target) {
            return l;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(twoSumLessThanK(new int[] {34,23,1,24,75,33,54,8}, 60));
    }
}
