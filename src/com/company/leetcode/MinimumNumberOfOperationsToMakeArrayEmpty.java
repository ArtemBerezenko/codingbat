package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : nums) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }

        int count = 0;
        for (Integer c: map.values()) {
            if (c == 1) {
                return -1;
            }
            count += (int) Math.ceil((double) c / 3);
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{19,19,19,19,19,19,19,19,19,19,19,19,19}));
    }
}
