package com.company.Leetcode;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = (m + n) - 1;
        m--;
        n--;
        while (n >= 0) {
            if (m >= 0 && nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0,0,3,0,0,0,0,0,0};
        int[] nums2 = new int[]{-1,1,1,1,2,3};
        merge(nums1, 3, nums2, 6);
        System.out.println(nums1);
    }
}