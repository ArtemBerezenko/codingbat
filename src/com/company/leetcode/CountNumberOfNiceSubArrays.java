package com.company.leetcode;

public class CountNumberOfNiceSubArrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        int total = 0;
        int currentCount = 0;

        while (j < nums.length) {

            if (nums[j++] % 2 == 1) {
                count++;
                currentCount = 0;
            }

            while (count == k) {
                currentCount++;
                if (nums[i++] % 2 == 1) {
                    count--;
                }
            }
            total += currentCount;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 2, 2, 2, 1}, 3));
    }
}
