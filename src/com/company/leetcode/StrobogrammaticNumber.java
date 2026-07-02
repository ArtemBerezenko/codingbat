package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {
    public static boolean isStrobogrammatic(String num) {
        Map<Integer, Integer> strobogrammatic = Map.of(
                6, 9,
                9, 6,
                8, 8,
                1, 1,
                0, 0);
        int l = 0;
        int r = num.length() - 1;

        while (l <= r) {
            int left = Integer.parseInt(String.valueOf(num.charAt(l)));
            int right = Integer.parseInt(String.valueOf(num.charAt(r)));

            if (strobogrammatic.get(left) == null || strobogrammatic.get(left) != right) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("2"));
    }
}
