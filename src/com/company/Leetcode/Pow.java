package com.company.Leetcode;

public class Pow {

    public static double myPow(double x, int n) {
        return pow(x, n);
    }

    private static double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n == 1) {
            return x;
        }

        if (n == -1) {
            return 1.0 / x;
        }

        if (n % 2 == 0) {
            double acc = pow(x, n / 2);
            return acc * acc;
        } else {
            double acc = pow(x, (n - 1) / 2);
            return x * acc * acc;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(34.00515, -3));
        System.out.println(myPow(34.00515, -3));
    }
}