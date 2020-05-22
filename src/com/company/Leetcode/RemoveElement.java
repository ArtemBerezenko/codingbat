package com.company.Leetcode;

import java.util.stream.IntStream;

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length - count; i++) {
            while (nums[i] == val && i < nums.length - count) {
                nums = removeFromStart(nums, i);
                count++;
            }
        }
        return nums.length - count;
    }

    private static int[] removeFromStart(int[] nums, int start) {
        if (nums.length - 1 - start >= 0) {
            System.arraycopy(nums, start + 1, nums, start, nums.length - 1 - start);
        }
        return nums;
    }

    public static int removeElementRIGHT(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int result = removeElementRIGHT(IntStream.of(0,1,2,2,3,0,4,2).toArray(), 2);
        System.out.println(result);
    }
}
