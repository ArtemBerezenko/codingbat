package com.company.leetcode;

public class FindTheMinimumAreaToCoverAllOnesI {
    public static int minimumArea(int[][] grid) {
        int[] hight = new int[grid.length];
        int[] length = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    hight[i] = 1;
                    length[j] = 1;
                }
            }
        }

        return getDiff(hight) * getDiff(length);
    }

    private static int getDiff(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l <= r && array[l] == 0) {
            l++;
        }
        while (r >= l && array[r] == 0) {
            r--;
        }
        if (l > r) {
            return 0;
        }
        return r - l + 1;
    }


    public static void main(String[] args) {
        System.out.println(minimumArea(new int[][]{{0,1,0},{1,0,1}}));
    }
}
