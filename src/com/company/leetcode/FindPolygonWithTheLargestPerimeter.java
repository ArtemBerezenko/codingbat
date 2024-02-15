package com.company.leetcode;

import java.util.Arrays;

public class FindPolygonWithTheLargestPerimeter {

    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        
        long sum = 0;
        long answer = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < sum) {
                answer = sum + nums[i];
            }
            sum += nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[] {5,5,50}));
    }
}
