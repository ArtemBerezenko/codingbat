package com.company.leetcode;

import java.util.HashSet;

public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            } else {
                set.add(nums[i]);
            }
        }
        return -1;
    }

    //Floyd's algorithm (tortoise and hare)
    public static int findDuplicate2(int[] nums) {
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Find the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        return hare;
    }



    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,3,1}));
        System.out.println(findDuplicate2(new int[]{1,2,3,1}));
    }
}
