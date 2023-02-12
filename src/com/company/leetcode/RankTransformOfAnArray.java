package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class RankTransformOfAnArray {
    public static int[] arrayRankTransform(int[] arr) {
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        List<Integer> sortedList = new ArrayList<>(set).stream().sorted().toList();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sortedList.size(); i++) {
            if (!map.containsKey(sortedList.get(i))) {
                map.put(sortedList.get(i), i + 1);
            }
        }

        int[] resultArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            resultArray[i] = map.get(arr[i]);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12}));
    }
}
