package com.company.Leetcode;

public class ValidPerfectSquare {

    public static boolean isPerfectSquare(int num) {
        long l = 1;
        long h = num;

        while (l <= h) {
            long mid = l + (h - l) / 2;
            long value = mid * mid;
            if (value == num) {
                return true;
            } else if (value > num) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
    }
}
