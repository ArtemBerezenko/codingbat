package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSumII(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[] {i, map.get(target - nums[i])};
            }
        }
        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {3,2,4};
        int k = 6;
        int[] result = twoSumII(array, k);
        System.out.println(Arrays.toString(result));
    }
}
