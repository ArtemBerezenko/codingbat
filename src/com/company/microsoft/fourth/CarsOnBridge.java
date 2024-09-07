package com.company.microsoft.fourth;

public class CarsOnBridge {

    public static int solution(int U, int[] weight) {
        int[] dp = new int[weight.length + 1];

        for (int i = 0; i <= weight.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 0; i < weight.length; i++) {
            for (int j = i + 1; j <= weight.length; j++) {
                int currentWeight = weight[i];
                if (j < weight.length) {
                    currentWeight += weight[j];
                }
                if (currentWeight <= U) {
                    dp[j] = Math.min(dp[j], dp[i] + (j - i - 1));
                } else {
                    dp[j] = Math.min(dp[j], dp[i] + j - i);
                }
            }
        }

        return dp[weight.length];
    }

    public static void main(String[] args) {
        System.out.println(solution(9, new int[]{5, 3, 8, 1, 8, 7, 7, 6}));
        System.out.println(solution(7, new int[]{7, 6, 5, 2, 7, 4, 5, 4}));
        System.out.println(solution(7, new int[]{3, 4, 3, 1}));
    }
}
