package com.company.Leetcode;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[h] > nums[0]) {
            return nums[0];
        }

        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
    }
}
