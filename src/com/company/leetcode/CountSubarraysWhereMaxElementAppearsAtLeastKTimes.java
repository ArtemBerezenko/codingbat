package com.company.leetcode;

import java.util.Arrays;
import java.util.stream.Stream;

public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int count = 0;
        long result = 0;
        long j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                count++;
            }
            while (count == k) {
                if (nums[(int) j] == max) {
                    count--;
                }
                j++;
            }
            result += j;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 2));
    }
}
