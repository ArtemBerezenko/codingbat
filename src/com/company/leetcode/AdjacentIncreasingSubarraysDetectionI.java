package com.company.leetcode;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (k <= 1) return true;
        if (2 * k > n) return false;

        int[] inc = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 0;
            }
        }

        for (int i = k - 1; i + k < n; i++) {
            if (inc[i] >= k - 1 && inc[i + k] >= k - 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasIncreasingSubarrays(List.of(2,5,7,8,9,2,3,4,3,1), 3));
    }
}
