package com.company.leetcode;

import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubarrays {
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[] {1,2,3,4}, new int[] {2,4,1,3}));
    }
}
