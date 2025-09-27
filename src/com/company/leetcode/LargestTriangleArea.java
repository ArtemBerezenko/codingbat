package com.company.leetcode;

public class LargestTriangleArea {
    public static double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; ++i) {
            for (int j = i+1; j < points.length; ++j) {
                for (int k = j+1; k < points.length; ++k) {
                    ans = Math.max(ans, area(points[i], points[j], points[k]));
                }
            }
        }
        return ans;
    }

    public static double area(int[] p, int[] q, int[] r) {
        return 0.5 * Math.abs(p[0]*q[1] + q[0]*r[1] + r[0]*p[1] - p[1]*q[0] - q[1]*r[0] - r[1]*p[0]);
    }

    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{
                {0, 0},
                {0, 1},
                {1, 0},
                {0, 2},
                {2, 0}
        }));
    }
}
