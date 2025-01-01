package com.company.leetcode;

public class MaximalSquare {
    private static int[][] memo;
    private static int result;

    public static int maximalSquare_TOP_DOWN(char[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        result = 0;

        dp(matrix, matrix.length - 1, matrix[0].length - 1);
        return result;
    }

    private static int dp(char[][] matrix, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        memo[i][j] = 1 + Math.min(Math.min(dp(matrix, i, j - 1), dp(matrix, i - 1, j)), dp(matrix, i - 1, j - 1));

        if (matrix[i][j] == '0') {
            memo[i][j] = 0;
            return 0;
        }

        result = Math.max(result, memo[i][j] * memo[i][j]);

        return memo[i][j];
    }


    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static int maximalSquareBETTER(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare_TOP_DOWN(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
