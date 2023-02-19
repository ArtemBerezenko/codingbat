package com.company.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Maximum69Number {
    public static int maximum69Number (int num) {
        int[] digits = String.valueOf(num).chars().map(i -> Character.digit(i, 10)).toArray();
        int i = 0;
        while (i < digits.length && digits[i] != 6) {
            i++;
        }
        if (i < digits.length && digits[i] == 6) {
            digits[i] = 9;
        }

        return Integer.valueOf(Arrays.stream(digits).boxed().map(String::valueOf).collect(Collectors.joining()));
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number(9999));
    }
}
