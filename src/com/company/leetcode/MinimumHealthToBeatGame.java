package com.company.leetcode;

public class MinimumHealthToBeatGame {
    public static long minimumHealth(int[] damage, int armor) {
        int max = 0;
        long total = 0;

        for (int i : damage) {
            total += i;
            max = Math.max(max, i);
        }

        return total - Math.min(armor, max) + 1;
    }

    public static void main(String[] args) {
        System.out.println(minimumHealth(new int[]{1,5,0,0,5}, 3));
    }
}
