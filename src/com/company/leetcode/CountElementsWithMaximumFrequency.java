package com.company.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (Integer i : nums) {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        }

        int max = map.values().stream().max(Comparator.comparing(Integer::intValue)).get();
        
        return map.values().stream()
                .filter(integer -> integer == max)
                .mapToInt(Integer::intValue)
                .sum();
    }


    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[] {1,2,2,3,1,4}));
    }
}
