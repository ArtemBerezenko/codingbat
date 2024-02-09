package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> eds = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            eds.add(new ArrayList<>());
        }

        for (int i = 0; i < nums.length; i++) {
            List<Integer> maxSubset = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && maxSubset.size() < eds.get(j).size()) {
                    maxSubset = eds.get(j);
                }
            }

            eds.get(i).addAll(maxSubset);
            eds.get(i).add(nums[i]);
        }
        
        return eds.stream().max(Comparator.comparing(List::size)).orElse(List.of());
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[] {1,2,4,7,8}));
    }
}
