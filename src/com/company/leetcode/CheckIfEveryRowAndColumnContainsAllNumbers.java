package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CheckIfEveryRowAndColumnContainsAllNumbers {
    public static boolean checkValid(int[][] matrix) {
        HashSet<Integer>[] rows = new HashSet[matrix.length];
        HashSet<Integer>[] colums = new HashSet[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            rows[i] = new HashSet<>();
            colums[i] = new HashSet<>();
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows[i].contains(matrix[i][j])) {
                    return false;
                }
                rows[i].add(matrix[i][j]);

                if (colums[j].contains(matrix[i][j])) {
                    return false;
                }
                colums[j].add(matrix[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkValid(new int[][] {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        }));
    }
}
