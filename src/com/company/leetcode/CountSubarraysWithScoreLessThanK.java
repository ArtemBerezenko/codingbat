package com.company.leetcode;

public class CountSubarraysWithScoreLessThanK {
    public static long countSubarrays(int[] nums, long k) {
        long result = 0;
        long sum = 0;

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];

            while (sum * (j - i + 1L) >= k) {
                sum -= nums[i];
                i++;
            }
            result += j - i + 1L;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[] {5,2,6,8,9,7}, 50));
    }
}
