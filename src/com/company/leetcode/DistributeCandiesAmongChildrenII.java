package com.company.leetcode;

public class DistributeCandiesAmongChildrenII {
    public static long distributeCandies(int n, int limit) {
        long ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(distributeCandies(5, 2));
    }
}
