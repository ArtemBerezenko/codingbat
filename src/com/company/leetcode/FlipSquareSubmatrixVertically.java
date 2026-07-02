package com.company.leetcode;

public class FlipSquareSubmatrixVertically {
    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int lr = x;
        int rr = x + k - 1;
        int c = y;

        while (lr < rr) {
            while (c < y + k) {
                var temp = grid[lr][c];
                grid[lr][c] = grid[rr][c];
                grid[rr][c] = temp;
                c++;
            }
            c = y;
            lr++;
            rr--;
        }

        return grid;
    }

    public static void main(String[] args) {
        System.out.println(reverseSubmatrix(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}, 1, 0, 3));
    }
}
