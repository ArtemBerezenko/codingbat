package com.company.leetcode;

public class ClosestPrimeNumbersInRange {
    public static int[] closestPrimes(int left, int right) {
        int prev = 0;
        int diff = Integer.MAX_VALUE;
        int[] result = new int[]{-1, -1};
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prev != 0) {
                    if (i - prev < diff) {
                        result[0] = prev;
                        result[1] = i;
                        diff = i - prev;
                    }
                }
                prev = i;
            }
        }

        return result;
    }

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false; // Eliminate even numbers

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(closestPrimes(19, 31));
    }
}
