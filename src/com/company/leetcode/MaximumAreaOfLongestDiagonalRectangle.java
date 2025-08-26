package com.company.leetcode;

public class MaximumAreaOfLongestDiagonalRectangle {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0;
        int area = 0;

        for (int i = 0; i < dimensions.length; i++) {
            double current = Math.sqrt((double) (dimensions[i][0] * dimensions[i][0]) + (double) (dimensions[i][1] * dimensions[i][1]));
            int currentArea = dimensions[i][0] * dimensions[i][1];

            if (current > max || (current == max && currentArea > area)) {
                max = current;
                area = currentArea;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        System.out.println(areaOfMaxDiagonal(new int[][]{{2,6},{5,1},{3,10},{8,4}}));
    }
}
