package com.company.Leetcode;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        String xs = Integer.toBinaryString(x);
        String ys = Integer.toBinaryString(y);
        int base = Math.max(xs.length(), ys.length());
        boolean[] xb = toBinary(x, base);
        boolean[] yb = toBinary(y, base);
        int count = 0;

        for (int i = 0; i < xb.length; i++) {
            if (yb.length >= i && yb[i] != xb[i]) {
                count++;
            }
        }
        return count;
    }

    private static boolean[] toBinary(int number, int base) {
        final boolean[] ret = new boolean[base];
        for (int i = 0; i < base; i++) {
            ret[base - 1 - i] = (1 << i & number) != 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
