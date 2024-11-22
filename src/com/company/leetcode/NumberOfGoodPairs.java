package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return map.values().stream()
                .filter(integer -> integer > 1)
                .map(n -> n * (n - 1)/2)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1,2,3,1,1,3}));
    }
}
