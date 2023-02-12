package com.company.Leetcode;

import java.util.Arrays;

public class ArrayPartition {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[] {6,2,6,5,1,2}));
    }

}
