package com.company.leetcode;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && target > nums[i]) {
            i++;
        }
        return i;
    }

    public static int binarySearchInsert(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while (l <= h) {
            int mid = l + ((h - l) / 2);
            if (target > nums[mid]) {
                l = mid + 1;
            } else if (target < nums[mid]){
                h = mid - 1;
            } else return mid;

        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(binarySearchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(binarySearchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(binarySearchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(binarySearchInsert(new int[]{1,3,5,6}, 0));
        System.out.println(binarySearchInsert(new int[]{1,3}, 2));

    }
}
