package com.company.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ElementAppearingMoreThan25InSortedArray {

    public static int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            resultMap.computeIfPresent(arr[i], (k, v) -> v + 1);
            resultMap.putIfAbsent(arr[i], 1);
        }
        
        return resultMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }
}
