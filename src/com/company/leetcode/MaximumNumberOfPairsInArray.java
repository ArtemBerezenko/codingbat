package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsInArray {
    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        int leftOver = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pairs += entry.getValue() / 2;
            leftOver += entry.getValue() % 2;
        }

        return new int[] {pairs, leftOver};
    }

    public static void main(String[] args) {
        System.out.println(numberOfPairs(new int[]{1,3,2,1,3,2,2}));
    }
}
