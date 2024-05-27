package com.company.leetcode;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static int specialArray(int[] nums) {
        int[] freq = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            freq[Math.min(nums.length, nums[i])]++;
        }

        int count = 0;
        for (int i = nums.length; i >= 1; i--) {
            count += freq[i];
            if (i == count) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(specialArray(new int[]{0,4,3,0,4}));
    }
}
