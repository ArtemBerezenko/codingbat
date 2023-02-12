package com.company.leetcode;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int min = Math.min(height[l], height[r]);
            max = getMax(min, max, l, r);

            while (height[l] <= min && l < r) {
                l++;
            }

            min = Math.min(height[l], height[r]);
            max = getMax(min, max, l, r);

            while (height[r] <= min && r > l) {
                r--;
            }

            min = Math.min(height[l], height[r]);
            max = getMax(min, max, l, r);

        }
        return max;
    }

    private static int getMax(int min, int max, int l, int r) {
        int current = min * (r - l);
        if (current > max) {
            max = current;
        }
        return max;
    }

    public int maxAreaSolution(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,3,10,5,7,8,9}));
    }
}
