package com.company.leetcode;

public class RotateImage {

    public static void rotate(int[][] matrix) {
        int r1Temp;
        int c1Temp;
        int c2Temp;
        int r2Temp;
        int n = matrix.length;

        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                r1Temp = matrix[i][j];
                c2Temp = matrix[j][n - 1 - i];
                r2Temp = matrix[n - 1 - i][n - 1 - j];
                c1Temp = matrix[n - 1 - j][i];

                matrix[i][j] = c1Temp;
                matrix[j][n - 1 - i] = r1Temp;
                matrix[n - 1 - i][n - 1 - j] = c2Temp;
                matrix[n - 1 - j][i] = r2Temp;
            }
        }
    }

    public static void main(String[] args) {
        mainMethod(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        mainMethod(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}});
        mainMethod(new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}});
    }

    private static void mainMethod(int[][] ints) {
        display(ints);
        rotate(ints);
        System.out.println("***");
        display(ints);
    }

    private static void display(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int item = matrix[i][j];
                System.out.print(item + ", ");
            }
            System.out.println("");
        }
    }
}
