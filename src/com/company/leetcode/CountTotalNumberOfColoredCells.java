package com.company.leetcode;

public class CountTotalNumberOfColoredCells {
    public static long coloredCells(int n) {
        long result = 1;

        for (int i = 0; i < n; i++) {
            result += i * 4L;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(coloredCells(3));
    }
}
