package com.company.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


public class FirstMissingPositiveII {

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int max = set.stream().max(Integer::compare).get();

        for (int i = 1; i < max; i++) {
            if (!set.contains(i)){
                return i;
            }
        }
        return max + 1 > 0 ? max + 1 : 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[] {7,8,9,11,12,-1,0,1}));
    }
}
