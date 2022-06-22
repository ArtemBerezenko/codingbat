package com.company.Leetcode;

public class FlippingAnImage {

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            handle(image[i]);
        }
        return image;
    }

    private static void handle(int[] array) {
        int l = 0;
        int h = array.length - 1;

        while (l <= h) {
            if (l == h) {
                array[l] = invert(array[l]);
            } else {
                int temp = invert(array[l]);
                array[l] = invert(array[h]);
                array[h] = temp;
            }
            l++;
            h--;
        }
    }

    private static int invert(int value) {
        return value == 0 ? 1 : 0;
    }


    public static void main(String[] args) {
        display(flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}));
    }

    public static void display(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
    }
}
