package com.company.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestMissingMultipleOfK {
    public static int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (int i = 1; i <= nums[nums.length - 1] + 1; i++) {
            if (!set.contains(i * k)) {
                return i * k;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println(missingMultiple(new int[]{8,2,3,4,6}, 2));
    }
}
