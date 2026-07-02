package com.company.leetcode;

public class BinaryGap {
    public static int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);

        int maxLength = 0;
        int current = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                maxLength = Math.max(maxLength, current);
                current = 0;
            }
            current++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
}
