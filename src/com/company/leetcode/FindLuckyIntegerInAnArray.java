package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindLuckyIntegerInAnArray {
    public static int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int max = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())) {
                max = Math.max(entry.getKey(), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2,2,3,4}));
    }
}
