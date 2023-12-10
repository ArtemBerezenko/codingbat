package com.company.leetcode;

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        int[][] resultMatrix = new int[matrix[0].length][matrix.length];
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                resultMatrix[j][i] = matrix[i][j];
            }
        }
        
        return resultMatrix;
    }

    public static void main(String[] args) {
        System.out.println(transpose(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }
}
