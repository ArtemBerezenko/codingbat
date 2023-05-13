package com.company.leetcode;

public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            left[i + 1] = left[i] + nums[i + 1];
        }

        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = right[i] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndexSOLUTION(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
    }
}
