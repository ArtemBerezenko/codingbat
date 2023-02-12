package com.company.leetcode;

public class Sqrt {

    public static int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1;
        int h = x - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (mid == x/mid) {
                return mid;
            } else if (mid > x/mid) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
