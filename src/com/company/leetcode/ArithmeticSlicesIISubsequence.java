package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    public static int numberOfArithmeticSlices(int[] nums) {
        long ans = 0;
        
        Map<Integer, Integer>[] cnt = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long) nums[i] - (long) nums[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int sum = cnt[j].getOrDefault(diff, 0);
                int origin = cnt[i].getOrDefault(diff, 0);
                cnt[i].put(diff, origin + sum + 1);
                ans += sum;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[] {1,2,1,2,4,1,5,10}));
    }
}
