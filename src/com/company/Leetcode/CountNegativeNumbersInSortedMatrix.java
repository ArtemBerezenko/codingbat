package com.company.Leetcode;

public class CountNegativeNumbersInSortedMatrix {

    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int firstNegativeColumn = n;
        int firstNegativeRow = m;
        int count = 0;

        for (int i = 0; i < firstNegativeRow; i++) {
            if ( grid[i][0] < 0) {
                count += (m - i) * firstNegativeColumn;
                break;
            }
            for (int j = 0; j < firstNegativeColumn; j++) {
                if (grid[i][j] < 0) {
                    count += (m - i) * (firstNegativeColumn - j);
                    firstNegativeColumn = j;
                    continue;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(countNegatives(new int[][]{
//                {4, 3, 2, -1},
//                {3, 2, 1, -1},
//                {1, 1, -1, -2},
//                {-1, -1, -2, -3}
//        }));

        System.out.println(countNegatives(new int[][]{
                {3,2},
                {-3,-3},
                {-3,-3},
                {-3,-3}
        }));

    }
}
