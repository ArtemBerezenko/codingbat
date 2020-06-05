package com.company.Leetcode;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && target > nums[i]) {
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }
}
