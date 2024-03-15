package com.company.leetcode;

public class BinarySubarraysWithSum {
    
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal) - helper(nums, goal - 1);
    }

    public static int helper(int[] nums, int goal) {
        int i = 0;
        int sum = 0;
        int count = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            
            while (i <= j && sum > goal) {
                sum -= nums[i++];
            }
            
            count += j - i + 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1,0,1,0,1}, 2));
    }
}
