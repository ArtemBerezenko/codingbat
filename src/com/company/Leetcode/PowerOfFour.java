package com.company.Leetcode;

public class PowerOfFour {

    public static boolean isPowerOfFour(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }

        if (n % 4 == 0) {
            return isPowerOfFour(n / 4);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(5));
    }
}
