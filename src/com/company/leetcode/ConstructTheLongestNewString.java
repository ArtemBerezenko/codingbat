package com.company.leetcode;

public class ConstructTheLongestNewString {
    public static int longestString(int x, int y, int z) {
        return x == y ? 2 * (2 * x + z) : 2 * (2 * Math.min(x, y) + 1 + z);
    }

    public static void main(String[] args) {
        System.out.println(longestString(2, 5, 1));
    }
}
