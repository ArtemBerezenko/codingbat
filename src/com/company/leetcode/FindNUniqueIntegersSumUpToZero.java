package com.company.leetcode;

public class FindNUniqueIntegersSumUpToZero {
    public static int[] sumZero(int n) {
        int[] res = new int[n];

        if (n % 2 != 0) {
            res[0] = 0;
            for (int i = 1; i < n; i += 2) {
                res[i] = i;
                res[i + 1] = -i;
            }
        } else {
            for (int i = 0; i < n; i += 2) {
                res[i] = i + 1;
                res[i + 1] = -(i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumZero(5));
    }
}
