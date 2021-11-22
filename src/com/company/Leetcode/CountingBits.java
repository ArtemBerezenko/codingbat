package com.company.Leetcode;

public class CountingBits {

    public static int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            result[i] = countOnes(Integer.toBinaryString(i));
        }
        return result;
    }

    private static int countOnes(String binaryStr) {
        int result = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                result += 1;
            }
        }
        return result;
    }

    public static int[] countBitsSolution(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i / 2] + (i % 2 == 0 ? 0 : 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        countBitsSolution(5);
    }
}
