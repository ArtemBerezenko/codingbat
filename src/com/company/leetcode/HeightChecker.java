package com.company.leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] sorted = Arrays.copyOf(heights, heights.length);

        Arrays.sort(sorted);

        int count = 0;

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != heights[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[] {1,1,4,2,1,3}));
    }

}
