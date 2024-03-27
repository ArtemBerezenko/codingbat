package com.company.leetcode;

public class SubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // Handle edge cases where k is 0 or 1 (no subarrays possible)
        if (k <= 1) return 0;

        int totalCount = 0;
        int product = 1;

        // Use two pointers to maintain a sliding window
        for (int l = 0, r = 0; r < nums.length; r++) {
            // Expand the window by including the element at the r pointer
            product *= nums[r];

            // Shrink the window from the l while the product is greater than or equal to k
            while (product >= k) {
                // Remove the element at the l pointer from the product
                product /= nums[l++];
            }

            // Update the total count by adding the number of valid subarrays with the current window size
            totalCount += r - l + 1;  // r - l + 1 represents the current window size
        }

        return totalCount;
        
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }
}
