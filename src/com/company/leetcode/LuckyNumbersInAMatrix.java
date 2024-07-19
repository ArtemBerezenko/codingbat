package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LuckyNumbersInAMatrix {
    public static List<Integer> luckyNumbers (int[][] matrix) {
        Set<Integer> mins = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[i].length; j++) {
                min = Math.min(min, matrix[i][j]);
            }
            mins.add(min);
        }

        Set<Integer> maxs = new HashSet<>();
        for (int i = 0; i < matrix[0].length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            maxs.add(max);
        }

        List<Integer> result = new ArrayList<>();
        for (Integer min : mins) {
            if (maxs.contains(min)) {
                result.add(min);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][] {{3,7,8},{9,11,13},{15,16,17}}));
    }
}
