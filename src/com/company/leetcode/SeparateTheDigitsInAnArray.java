package com.company.leetcode;

import java.util.Arrays;

public class SeparateTheDigitsInAnArray {
    public static int[] separateDigits(int[] nums) {
        var sb = new StringBuilder();
        for (int i : nums) {
            sb.append(i);
        }

        return Arrays.stream(sb.toString().split("")).sequential().mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String[] args) {
        System.out.println(separateDigits(new int[]{13,25,83,77}));
    }
}
