package com.company.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public static int minimumOperations(int[] nums) {
        return Arrays.stream(nums).boxed().filter(v -> v > 0).collect(Collectors.toSet()).size();
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,2,3,5}));
    }
    
}
