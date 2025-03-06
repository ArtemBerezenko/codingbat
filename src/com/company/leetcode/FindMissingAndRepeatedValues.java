package com.company.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingAndRepeatedValues {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();

        int[] result = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (set.contains(grid[i][j])) {
                    result[0] = grid[i][j];
                }
                set.add(grid[i][j]);
            }
        }

        List<Integer> list = set.stream().sorted().toList();
        int missing = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != i + 1) {
               missing = i + 1;
               break;
            }
        }

        result[1] = missing == 0 ? list.size() + 1 : missing;

        return result;
    }

    public static void main(String[] args) {
        System.out.println(findMissingAndRepeatedValues(new int[][]{{9,1,7}, {8,9,2}, {3,4,6}}));
    }
}
