package com.company.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LargestPerimeterTriangle {
    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);

        for (int i = nums.length - 3; i >= 0; i--) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            int sum = a + b + c;
            if (a + b > c && a + c > b && b + c > a) {
                    return sum;
                }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,6,2,3}));
    }
}
