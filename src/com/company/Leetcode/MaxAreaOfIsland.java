package com.company.Leetcode;

public class MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (!isIsland(grid, i, j)) {
            return 0;
        }

        int current = 1;
        grid[i][j] = 0;
        current += dfs(grid, i - 1, j);
        current += dfs(grid, i + 1, j);
        current += dfs(grid, i, j - 1);
        current += dfs(grid, i, j + 1);

        return current;
    }

    private static boolean isIsland(int[][] grid, int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[row].length && grid[row][column] == 1;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        }));
    }
}
