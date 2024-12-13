package com.company.leetcode;

public class ScoreOfAString {
    public static int scoreOfString(String s) {
        int[] ints = s.chars().toArray();

        int sum = 0;
        for (int i = 1; i < ints.length; i++) {
            sum += Math.abs(ints[i - 1] - ints[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }
}
