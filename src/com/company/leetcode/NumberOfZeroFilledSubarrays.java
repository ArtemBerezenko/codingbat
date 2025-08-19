package com.company.leetcode;

public class NumberOfZeroFilledSubarrays {
    public static long zeroFilledSubarray(int[] nums) {
        long sum = 0;
        long subarray = 0;

        for (int n : nums) {
            if (n == 0) {
                subarray++;
            } else {
                subarray = 0;
            }
            sum += subarray;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[] {1,3,0,0,2,0,0,4}));
    }
}
