package com.company.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    
    public static int[][] onesMinusZeros(int[][] grid) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> columns = new HashMap<>();
        
        for (int i = 0; i < grid.length; i++) {
            List<Integer> rowList = new ArrayList<>();
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            rowList.add(zeros);
            rowList.add(ones);
            rows.put(i, rowList);
        }
        
        for (int i = 0; i < grid[0].length; i++) {            
            List<Integer> columnList = new ArrayList<>();
            int zeros = 0;
            int ones = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 0) {
                    zeros++;
                } else {
                    ones++;
                }
            }
            columnList.add(zeros);
            columnList.add(ones);
            columns.put(i, columnList);
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                List<Integer> rowList = rows.get(i);
                List<Integer> columList = columns.get(j);
                grid[i][j] = rowList.get(1) + columList.get(1) - rowList.get(0) - columList.get(0);
            }
        }
        return grid;
    }


    public static void main(String[] args) {
        System.out.println(onesMinusZeros(new int[][]{{1,1,1},{1,1,1}}));
    }
}
