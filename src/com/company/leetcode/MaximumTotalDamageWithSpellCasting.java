package com.company.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximum-total-damage-with-spell-casting
 */
public class MaximumTotalDamageWithSpellCasting {

    public static long maximumTotalDamage(int[] power) {
        Map<Integer, Long> freq = new HashMap<>();

        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }

        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = keys.getFirst() * freq.get(keys.getFirst());

        for (int i = 1; i < n; i++) {
            long take = keys.get(i) * freq.get(keys.get(i));
            int prev = binarySearch(keys, i - 1, keys.get(i) - 3);
            if (prev >= 0) {
                take += dp[prev];
            }
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }

    private static int binarySearch(List<Integer> keys, int end, int value) {
        int l = 0;
        int r = end;
        int ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (keys.get(mid) <= value) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maximumTotalDamage(new int[] {7,1,6,6}));
    }
}
