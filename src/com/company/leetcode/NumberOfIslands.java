package com.company.leetcode;

public class NumberOfIslands {

    static int[] dr = new int[] {1, -1, 0, 0};
    static int[] dc = new int[] {0, 0, 1, -1};

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int row, int column) {
        if (!isValid(grid, row, column)) {
            return;
        }
        grid[row][column] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, row + dr[i], column + dc[i]);
        }
    }

    static boolean isValid(char[][] grid, int row, int column) {
        return 0 <= row && row < grid.length && 0 <= column && column < grid[0].length && grid[row][column] == '1';
    }

    public static void main(String[] args) {
        System.out.println(numIslands(new char[][] {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}}));
    }
}

//        ["1","1","0","0","0"],
//        ["1","1","0","0","0"],
//        ["0","0","1","0","0"],
//        ["0","0","0","1","1"]