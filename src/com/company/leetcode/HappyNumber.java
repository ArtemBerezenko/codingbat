package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = next(n);
        }
        return n == 1;
    }

    public static boolean isHappyTwoPointers(int n) {
        int slow = n;
        int fast = next(n);
        while (fast != 1 && slow != fast) {
            slow = next(slow);
            fast = next(next(fast));
        }
        return fast == 1;
    }

    private static int next(int n) {
        int sum = 0;
        while (n > 0) {
            int a = n % 10;
            n = n / 10;
            sum += Math.pow(a, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

}
