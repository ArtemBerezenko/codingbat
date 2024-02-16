package com.company.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            map.computeIfPresent(arr[i], (a, v) -> v + 1);
            map.putIfAbsent(arr[i], 1);
        }

        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .toList();

        for (Map.Entry<Integer, Integer> entry : list) {
            if (k > 0) {
                final int n = k;
                k -= entry.getValue();
                map.computeIfPresent(entry.getKey(), (a, v) -> v - n);
            }
        }
        
        return (int) map.entrySet().stream().filter(e -> e.getValue() > 0).count();
    }

    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[] { 4,3,1,1,3,3,2 }, 3));
    }
}
