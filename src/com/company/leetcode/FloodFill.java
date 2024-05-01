package com.company.leetcode;

public class FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            dfs(image, sr, sc, image[sr][sc], color);
        }
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int color,  int newColor) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
            if (sr >= 1) {
                dfs(image, sr - 1, sc, color, newColor);
            }
            if (sc >= 1) {
                dfs(image, sr, sc - 1, color, newColor);
            }
            if (sr + 1 < image.length) {
                dfs(image, sr + 1, sc, color, newColor);
            }
            if (sc + 1 < image[0].length) {
                dfs(image, sr, sc + 1, color, newColor);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(floodFill(new int[][] {{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2));

    }
}
