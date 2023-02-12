package com.company.leetcode;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;

        int[] result = new int[nums.length];

        for (int i = 0; i < k; i++) {
            result[i] = nums[nums.length - k + i];
        }

        for (int i = k; i < nums.length; i++) {
            result[i] = nums[i - k];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public static int[] rotateSolution(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k -1);
        reverse(nums, k, nums.length  - 1);
        return nums;
    }

    private static void reverse(int[] nums, int start, int end){
        while (start < end ){
            int  temp  = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotateSolution(nums, 3);
        display(nums);

        int[] nums1 = {1, 2, 3, 4};
        rotate(nums1, 2);
        display(nums1);
    }

    private static void display(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
    }
}