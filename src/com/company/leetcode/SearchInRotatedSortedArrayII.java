package com.company.leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int[] ints = Arrays.stream(nums).sorted().distinct().toArray();
        int l = 0;
        int h = ints.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (ints[mid] == target) {
                return true;
            } else if (ints[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(search(new int[] {2,5,6,0,0,1,2}, 3));
    }

}
