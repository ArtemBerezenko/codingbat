package com.company.leetcode;

import java.util.*;

/*
    16. 3Sum Closest
 */
public class Sum3Closest {

    public static int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    if (sum - target < Math.abs(closest - target)) {
                        closest = sum;
                    }
                    k--;
                } else if (sum < target) {
                    if (target - sum < Math.abs(target - closest)) {
                        closest = sum;
                    }
                    j++;
                }
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,0,1,1,55}, 3));
    }
}
