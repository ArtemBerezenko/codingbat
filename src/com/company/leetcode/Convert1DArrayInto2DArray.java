package com.company.leetcode;

public class Convert1DArrayInto2DArray {

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int [][] result = new int[m][n];

        if (original.length % n != 0 || original.length / n != m) {
            return new int[][] {};
        }

        int r = 0;
        int c = 0;
        for (int i = 0; i < original.length; i++) {
            if (c == n) {
                r++;
                c = 0;
            }
            result[r][c] = original[i];
            c++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(construct2DArray(new int[] {5,3,8,9,7,9,1,2,2,3,9}, 1, 6));
    }
}
