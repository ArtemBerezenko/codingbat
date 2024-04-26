package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            left.putIfAbsent(nums[i], i);
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        int result = nums.length;
        int max = count.values().stream().max(Integer::compareTo).orElse(0);

        for (int i : count.keySet()) {
            if (count.get(i) == max) {
                result = Math.min(result, right.get(i) - left.get(i) + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 5, 2, 3, 5, 4, 5, 6}));

    }
}
