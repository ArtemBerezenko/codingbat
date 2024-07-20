package com.company.leetcode;

public class FindValidMatrixGivenRowAndColumnSums {
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[][] origMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                origMatrix[i][j] = Math.min(rowSum[i], colSum[j]);

                rowSum[i] -= origMatrix[i][j];
                colSum[j] -= origMatrix[i][j];
            }
        }

        return origMatrix;
    }

    public static void main(String[] args) {
        System.out.println(restoreMatrix(new int[]{3,8}, new int[]{4,7}));
    }
}
