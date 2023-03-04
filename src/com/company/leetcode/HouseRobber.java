package com.company.leetcode;

public class HouseRobber {


    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] array = new int[nums.length];
        array[0] = nums[0];
        array[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            array[i] = Math.max(array[i - 1], array[i - 2] + nums[i]);
        }

        return array[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
    }
}
