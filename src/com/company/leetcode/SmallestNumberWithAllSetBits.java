package com.company.leetcode;

public class SmallestNumberWithAllSetBits {
    public static int smallestNumber(int n) {
        String bin = Integer.toBinaryString(n);

        var sb = new StringBuilder();
        for (int i = 0; i < bin.length(); i++) {
            sb.append("1");
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(smallestNumber(5));
    }
}
