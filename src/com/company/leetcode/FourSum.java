package com.company.leetcode;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    public static List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if (start == nums.length) {
            return res;
        }

        long average_value = target / k;
        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return res;
        }

        if (k == 2) {
            return twoSum(nums, target, start);
        }

        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(subset);
                }
            }
        }

        return res;
    }

    public static List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int l = start;
        int h = nums.length - 1;

        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum < target || (l > start && nums[l] == nums[l - 1])) {
                ++l;
            } else if (sum > target || (h < nums.length - 1 && nums[h] == nums[h + 1])) {
                --h;
            } else {
                res.add(Arrays.asList(nums[l++], nums[h--]));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[] {1,0,-1,0,-2,2}, 0));
    }
}
