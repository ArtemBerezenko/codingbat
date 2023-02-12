package com.company.leetcode;

public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            a ^= nums[i];
        }
        return a;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{2,2,1});
    }
}
