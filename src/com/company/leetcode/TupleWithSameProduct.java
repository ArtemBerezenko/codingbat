package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }

        return map.values().stream()
                .filter(value -> value > 1)
                .mapToInt(count -> count * (count - 1) / 2 * 8)
                .sum();

    }

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[] {1,2,4,5,10}));
    }
}
