package com.company.leetcode;

import java.util.Set;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static int countPrimeSetBits(int left, int right) {
        Set<Integer> set = Set.of(2, 3, 5, 7, 11, 13, 17, 19);

        int countPrime = 0;
        for (int i = left; i <= right; i++) {
            countPrime += set.contains(count(Integer.toBinaryString(i))) ? 1 : 0;
        }
        return countPrime;
    }

    private static int count(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
    }
}
