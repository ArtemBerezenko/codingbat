package com.company.Leetcode;

public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        long l = 0;
        long h = n;

        while (h >= l) {
            long mid = l + (h - l) / 2;
            long coins = mid * (mid + 1) / 2;

            if (coins == n) {
                return (int) mid;
            } else if (coins < n) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return (int) h;
    }


    public static void main(String[] args) {
        System.out.println(arrangeCoins(1804289383));
    }

}
