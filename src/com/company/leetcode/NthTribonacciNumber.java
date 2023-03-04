package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        if (!map.containsKey(n)) {
            map.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        }
        return map.get(n);
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
