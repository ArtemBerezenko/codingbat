package com.company.leetcode;

public class SingleElementInASortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (mid % 2 > 0) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }

        return nums[l];

    }


    public static void main(String[] args) {
        //3,3,7,7,10,11,11
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }
}
