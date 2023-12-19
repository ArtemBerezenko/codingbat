package com.company.leetcode;

public class ImageSmoother {
    public static int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int sum = img[i][j];
                int count = 1;
                
                if (j - 1 >= 0 && i - 1 >= 0) {
                    sum += img[i - 1][j - 1];
                    count++;
                }
                if (j - 1 >= 0 && i + 1 < img.length) {
                    sum += img[i + 1][j - 1];
                    count++;
                }
                if (j + 1 < img[0].length && i + 1 < img.length) {
                    sum += img[i + 1][j + 1];
                    count++;
                }

                if (j + 1 < img[0].length && i - 1 >= 0) {
                    sum += img[i - 1][j + 1];
                    count++;
                }
                if (j - 1 >= 0) {
                    sum += img[i][j - 1];
                    count++;
                }
                if (j + 1 < img[0].length) {
                    sum += img[i][j + 1];
                    count++;
                }
                if (i - 1 >= 0) {
                    sum += img[i - 1][j];
                    count++;
                }
                if (i + 1 < img.length) {
                    sum += img[i + 1][j];
                    count++;
                }
                result[i][j] = sum / count;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(imageSmoother(new int[][] { {100,200,100},{200,50,200},{100,200,100} }));
    }
    
}
