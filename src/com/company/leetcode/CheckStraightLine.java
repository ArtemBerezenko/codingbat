package com.company.leetcode;

public class CheckStraightLine {
    public static boolean checkStraightLine(int[][] coordinates) {
        
        if (coordinates.length <= 2) {
            return true;
        }
        
        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];
        
        for (int i = 2; i < coordinates.length; i++) {
            int currX = coordinates[i][0] - coordinates[i - 1][0];
            int currY = coordinates[i][1] - coordinates[i - 1][1];
            
            if (x * currY != y * currX) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{0,0},{1,1},{-1,-1}}));
    }
}
