package com.company.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static int findMaxK(int[] nums) {
        Map<Boolean, List<Integer>> groups = Arrays.stream(nums).boxed()
                .collect(Collectors.partitioningBy(i -> i > 0));

        List<Integer> positives = groups.get(true);
        List<Integer> negatives = groups.get(false);

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer i : positives) {
            if (negatives.contains(-i)) {
                map.put(i, -i);
            }
        }

        if (map.isEmpty()) {
            return -1;
        }

        return map.keySet().stream().max(Integer::compareTo).orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findMaxK(new int[] {-1,2,-3,3}));

    }
}
