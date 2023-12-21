package com.company.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class WidestAreaBetweenTwoPointsContainingNoPoints {

    public static int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int result = 0;
        
        for (int i = 1; i < points.length; i++) {
            result = Math.max(result, points[i][0] - points[i - 1][0]);
        }
        
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxWidthOfVerticalArea(new int[][] { {3,1},{9,0},{1,0},{1,4},{5,3},{8,8} }));
    }
    
}
