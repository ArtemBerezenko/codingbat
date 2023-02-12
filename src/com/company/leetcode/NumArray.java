package com.company.leetcode;

public class NumArray {
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        if (left > nums.length - 1) return sum;
        if (right > nums.length - 1) return sum;

        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }


    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[] {-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
    }
}
