package com.company.leetcode;

import java.util.*;

public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int value : arr2) {
            countMap.put(value, 0);
        }

        for (int value : arr1) {
            if (countMap.containsKey(value)) {
                countMap.put(value, countMap.get(value) + 1);
            } else {
                remaining.add(value);
            }
        }

        Collections.sort(remaining);

        for (int value : arr2) {
            for (int j = 0; j < countMap.get(value); j++) {
                result.add(value);
            }
        }

        result.addAll(remaining);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(relativeSortArray(
                new int[] {2,3,1,3,2,4,6,7,9,2,19},
                new int[] {2,1,4,3,9,6}
        ));
    }
}
