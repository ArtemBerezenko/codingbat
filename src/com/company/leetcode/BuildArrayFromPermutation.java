package com.company.leetcode;

public class BuildArrayFromPermutation {
    public static int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(buildArray(new int[] {0,2,1,5,3,4}));
    }


}
