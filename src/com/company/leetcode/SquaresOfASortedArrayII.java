package com.company.leetcode;

import java.util.Arrays;

public class SquaresOfASortedArrayII {
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) Math.pow(Math.abs(nums[i]), 2);
        }
        Arrays.sort(nums);
        
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[] {-4,-1,0,3,10}));
    }
}
