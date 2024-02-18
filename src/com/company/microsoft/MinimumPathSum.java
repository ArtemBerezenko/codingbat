package com.company.microsoft;

public class MinimumPathSum {
    
    public static int solution(int[] A, int[] B) {
        int[][] grid = new int[2][];
        grid[0] = new int[A.length];
        grid[1] = new int[B.length];
        
        for (int i = 0; i < A.length; i++) {
            grid[0][i] = A[i];
            grid[1][i] = B[i];
        }
        
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = Math.max(grid[i][j], dp[j + 1]);
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = Math.max(grid[i][j], dp[j]);
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = Math.max(grid[i][j], Math.min(dp[j], dp[j + 1]));
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 6}, new int[]{6, 5, 4}));
    }
}
