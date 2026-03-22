package com.company.leetcode;

import java.util.Arrays;

public class DetermineWhetherMatrixCanBeObtainedByRotation {
    public static boolean findRotation(int[][] mat, int[][] target) {
        return Arrays.deepEquals(rotateTo90(mat), target) || Arrays.deepEquals(rotateTo180(mat), target) || Arrays.deepEquals(rotateTo270(mat), target) || Arrays.deepEquals(mat, target);
    }

    private static int[][] rotateTo90(int[][] grid) {
        return reversRows(transpose(grid));
    }

    private static int[][] rotateTo180(int[][] grid) {
        return reversRows(reverseColumns(grid));
    }

    private static int[][] rotateTo270(int[][] grid) {
        int[][] ints = transpose(grid);
        return reverseColumns(ints);
    }

    private static int[][] transpose(int[][] grid) {
        int[][] arr = new int[grid[0].length][grid.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = grid[j][i];
            }
        }
        return arr;
    }


    private static int[][] reverseColumns(int[][] grid) {
        int[][] arr = new int[grid[0].length][grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = grid[i][arr[0].length - j - 1];
            }
        }

        return arr;
    }


    private static int[][] reversRows(int[][] grid) {
        int[][] arr = new int[grid[0].length][grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = grid[arr.length - i - 1][j];
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(findRotation(new int[][]{{0,0,0},{0,1,0},{1,1,1}}, new int[][]{{1,1,1},{0,1,0},{0,0,0}}));
    }
}
