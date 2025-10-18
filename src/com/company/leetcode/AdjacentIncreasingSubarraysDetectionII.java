package com.company.leetcode;

import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII {
    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        int[] reverse = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 0;
            }
        }

        for (int i = n - 2; i > 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                reverse[i] = reverse[i + 1] + 1;
            } else {
                reverse[i] = 0;
            }
        }

        int ans = 0;
        for (int i = 0; i + 1 < n; i++){
            ans = Math.max(ans, Math.min(inc[i] + 1, reverse[i + 1] + 1));
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxIncreasingSubarrays(List.of(2,5,7,8,9,2,3,4,3,1)));
    }
}
