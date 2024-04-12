package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {
    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;

        int[][] ps = new int[r + 1][c + 1];
        for (int i = 1; i < r + 1; ++i) {
            for (int j = 1; j < c + 1; ++j) {
                ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

        int count = 0, currSum;
        Map<Integer, Integer> h = new HashMap<>();
        for (int i = 1; i < r + 1; ++i) {
            for (int j = i; j < r + 1; ++j) {
                h.clear();
                h.put(0, 1);
                for (int col = 1; col < c + 1; ++col) {
                    currSum = ps[j][col] - ps[i - 1][col];

                    count += h.getOrDefault(currSum - target, 0);

                    h.put(currSum, h.getOrDefault(currSum, 0) + 1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}}, 0));
    }
}
