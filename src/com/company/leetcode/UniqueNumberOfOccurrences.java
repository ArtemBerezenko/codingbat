package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], 1);
            map.computeIfPresent(arr[i], (k, v) -> v + 1);
        }

        return map.values().stream().distinct().count() == map.keySet().size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3}));
    }
}
