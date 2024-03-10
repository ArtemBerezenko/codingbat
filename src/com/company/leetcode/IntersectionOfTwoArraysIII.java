package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArraysIII {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());

        List<Integer> list = new ArrayList<>();
        for (Integer i : nums2) {
            if (set.contains(i)) {
                list.add(i);
            }
        }
        
        return list.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[]{1,2,2,1}, new int[]{2,2}));
    }
}
