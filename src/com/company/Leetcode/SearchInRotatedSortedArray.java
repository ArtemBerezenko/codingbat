package com.company.Leetcode;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while (l <= h) {
            if (nums[l] == target) {
                return l;
            }
            if (nums[h] == target) {
                return h;
            }
            l++;
            h--;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
    }

}
