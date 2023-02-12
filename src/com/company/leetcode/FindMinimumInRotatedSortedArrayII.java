package com.company.leetcode;

public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int l = 0;
        int h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            if (nums[mid] > nums[h]) {
                l = mid + 1;
            } else if (nums[mid] < nums[h]) {
                h = mid;
            } else {
                h--;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2,2,2,2,2,0,1}));
    }
}