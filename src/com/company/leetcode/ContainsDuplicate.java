package com.company.leetcode;

import java.util.Arrays;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        int[] withoutDuplicates = Arrays.stream(nums).distinct().toArray();
        return nums.length != withoutDuplicates.length;
    }

    public static int missingNumber(int[] nums) {
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sortedArray.length; i++) {
            if (sortedArray[i] != i) {
                return i;
            }
        }
        if (sortedArray[sortedArray.length - 1] != sortedArray.length) {
            return sortedArray.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(missingNumber(new int[]{8,6,4,2,3,5,7,0,1}));
    }

}
