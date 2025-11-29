package com.company.leetcode;

import java.util.Arrays;

public class MinimumOperationsToMakeArraySumDivisibleByK {

    public static int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).boxed().mapToInt(i -> i).sum();
        int i = 0;
        while (sum % k != 0) {
            sum--;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[] {3,9,7}, 5));
    }
}
