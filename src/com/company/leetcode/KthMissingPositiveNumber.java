package com.company.leetcode;

public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int h = arr.length;

        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] - mid - 1 < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }
        return l + k;
    }


    public static void main (String[] args){
        System.out.println(findKthPositive(new int[] {2,3,4,7,11}, 5));
    }

}
