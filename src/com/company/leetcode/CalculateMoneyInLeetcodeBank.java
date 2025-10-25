package com.company.leetcode;

public class CalculateMoneyInLeetcodeBank {
    public static int totalMoney(int n) {
        int sum = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += j + 1 + (i/7);
            j++;
            if (j == 7) {
                j = 0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }
}
