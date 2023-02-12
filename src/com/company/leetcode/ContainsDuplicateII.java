package com.company.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate1(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;

        while (j <= k && j < nums.length) {
            int num = nums[j];
            if (!set.add(num)) {
                return true;
            }
            j++;
        }

        while (j < nums.length) {
            set.remove(nums[i++]);
            int cur = nums[j++];
            if (!set.add(cur)) {
                return true;
            }
        }
        return false;
    }


    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length == 1 || k == 0) {
            return false;
        }

        int i = 0;

        while (i < nums.length) {
            int n = Math.min(nums.length - 1, k + i);
            while (n > i) {
                if (nums[i] == nums[n]) {
                    return true;
                }
                n--;
            }
            i++;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate1(new int[]{0, 1, 2, 3, 2, 5}, 3));
    }
}
