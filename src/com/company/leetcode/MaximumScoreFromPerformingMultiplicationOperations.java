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

    public static int maximumScore_Bottom_Up(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int left = i; left >= 0; left--) {
                int right = n - 1 - (i - left);
                dp[i][left] = Math.max(multipliers[i] * nums[left] + dp[i + 1][left + 1],
                        multipliers[i] * nums[right] + dp[i + 1][left]);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(maximumScore_Bottom_Up(new int[] {1,2,3}, new int[] {3,2,1}));
    }
}
