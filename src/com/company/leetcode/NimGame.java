package com.company.leetcode;

public class NimGame {
    public static boolean canWinNim(int n) {
        return n <= 3 || n % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(canWinNim(8));
    }
}
