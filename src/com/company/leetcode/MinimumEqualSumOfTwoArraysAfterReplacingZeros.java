package com.company.leetcode;

import java.util.Arrays;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = Arrays.stream(nums1).boxed().mapToLong(i -> i).sum();
        long sum2 = Arrays.stream(nums2).boxed().mapToLong(i -> i).sum();

        long zeros1 = Arrays.stream(nums1)
                .boxed()
                .mapToInt(i -> i)
                .filter(i -> i == 0)
                .count();

        long zeros2 = Arrays.stream(nums2)
                .boxed()
                .mapToInt(i -> i)
                .filter(i -> i == 0)
                .count();

        if (sum1 + zeros1 > sum2 && zeros2 == 0) {
            return -1;
        }

        if (sum2 + zeros2 > sum1 && zeros1 == 0) {
            return -1;
        }

        return Math.max(sum1 + zeros1, sum2 + zeros2);
    }

    public static void main(String[] args) {
        System.out.println(minSum(new int[] {3,2,0,1,0}, new int[] {6,5,0}));
    }
}
