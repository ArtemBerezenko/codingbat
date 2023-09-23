package com.company.leetcode;

public class ContainsDuplicateIII {
    
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - indexDiff, 0); j < i; j++) {
                if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,2,3,4,5}, 3, 0));
    }
}
