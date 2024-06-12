package com.company.leetcode;

public class SortColors {
    public static void sortColors(int[] nums) {
        int i = 0;
        int l = 0;
        int r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                int tmp = nums[l];
                nums[l++] = nums[i];
                nums[i++] = tmp;
            } else if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[r];
                nums[r--] = tmp;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        sortColors(new int[]{2,0,1});
    }
}
