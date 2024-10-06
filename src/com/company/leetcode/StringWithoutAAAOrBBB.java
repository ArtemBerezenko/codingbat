package com.company.leetcode;

public class StringWithoutAAAOrBBB {
    public static String strWithout3a3b(int a, int b) {
        return helper(a, b, "", a >= b);
    }

    private static String helper(int a, int b, String str, boolean isA) {
        if (a <= 0 && b <= 0) {
            return str;
        }
        if (isA) {
            if (a == 0) {
                return helper(a, b, str, false);
            }
            if (a < 2 || a < b) {
                return helper(a - 1, b, str + "a", false);
            } else {
                return helper(a - 2, b, str + "aa", false);
            }
        } else {
            if (b == 0) {
                return helper(a, b, str, true);
            }
            if (b < 2 || b < a) {
                return helper(a, b - 1, str + "b", true);
            } else {
                return helper(a, b - 2, str + "bb", true);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(strWithout3a3b(3, 7));
    }
}
