package com.company.leetcode;


public class CheckIfArrayIsSortedAndRotated {

    public static boolean check(int[] nums) {
        int count = 0;

        if (nums[nums.length - 1] > nums[0]) {
            count++;
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
    }
}
