package com.company.leetcode;

public class FindThePivotInteger {
    public static int pivotInteger(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }

        int current = 0;
        for (int i = 0; i <= n; i++) {
            current += i;
            if (current == sum) {
                return i;
            }
            sum -= i;
        }

        return -1;
    }


    public int pivotInteger_niceSolutionFromEditorial(int n) {
        final int sum = (n * (n + 1) / 2);
        final int pivot = (int) Math.sqrt(sum);
        // If pivot * pivot is equal to sum (pivot found) return pivot, else return -1
        return pivot * pivot == sum ? pivot : -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }
}
