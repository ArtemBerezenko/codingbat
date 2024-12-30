package com.company.leetcode;

public class MaximumScoreFromPerformingMultiplicationOperations {
    private static int[][] memo;
    private static int[] nums;
    private static int[] multipliers;

    public static int maximumScore(int[] nums, int[] multipliers) {
        MaximumScoreFromPerformingMultiplicationOperations.nums = nums;
        MaximumScoreFromPerformingMultiplicationOperations.multipliers = multipliers;
        memo = new int[multipliers.length][multipliers.length];

        return dp(0, 0);
    }

    private static int dp(int i, int left) {
        if (i == multipliers.length) {
            return 0;
        }
        int right = nums.length - 1 - (i - left);

        if (memo[i][left] == 0) {
            memo[i][left] = Math.max(nums[left] * multipliers[i] + dp(i + 1, left + 1),
                    nums[right] * multipliers[i] + dp(i + 1, left));
        }
        return memo[i][left];
    }

    public static void main(String[] args) {
        System.out.println(maximumScore(new int[] {1,2,3}, new int[] {3,2,1}));
    }
}
