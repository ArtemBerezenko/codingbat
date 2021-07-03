package com.company.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    //my solution
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                result.add(matrix[0][i]);
            }
            return result;
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length; i++) {
                result.add(matrix[i][0]);
            }
            return result;
        }
        var length = matrix.length;
        int rowSize = (length & 1) == 0 ? length / 2 : (length / 2) + 1;
        length = matrix[0].length;
        int columnSize = (matrix[0].length & 1) == 0 ? length / 2 : length / 2 + 1;
        for (int k = 0; k < rowSize && k < columnSize; k++) {
            for (int i = k; i < matrix[k].length - k; i++) {
                result.add(matrix[k][i]);
            }
            for (int i = k + 1; i < matrix.length - k - 1; i++) {
                result.add(matrix[i][matrix[i].length - k - 1]);
            }
            if (matrix.length - k > rowSize) {
                for (int i = matrix[matrix.length - 1 - k].length - k - 1; i >= k; i--) {
                    result.add(matrix[matrix.length - k - 1][i]);
                }
            }
            if (matrix[k].length - k > columnSize) {
                for (int i = matrix.length - k - 2; i > k; i--) {
                    result.add(matrix[i][k]);
                }
            }
        }
        return result;
    }

    public static List<Integer> spiralOrderSimulationSolution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;
        boolean[][] seen = new boolean[rowLength][columnLength];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < rowLength * columnLength; i++) {
            result.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (cr >= 0 && cr < rowLength && cc >= 0 && cc < columnLength && !seen[cr][cc]) {
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return result;
    }

    public static List<Integer> spiralOrderLayerByLayerSolution(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0)
            return result;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) {
                result.add(matrix[r1][c]);
            }
            for (int r = r1 + 1; r <= r2; r++) {
                result.add(matrix[r][c2]);
            }
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    result.add(matrix[r2][c]);
                }
                for (int r = r2; r > r1; r--) {
                    result.add(matrix[r][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrderSimulationSolution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrderLayerByLayerSolution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
//        System.out.println(spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}}));
//        System.out.println(spiralOrder(new int[][]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}}));
//        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
//        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
//        System.out.println(spiralOrder(new int[][]{{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}}));
    }
}
