package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class DecompressRunLengthEncodedList {
    public static int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length; i = i + 2) {
            int n = nums[i - 1];

            while (n > 0) {
                list.add(nums[i]);
                n--;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        System.out.println(decompressRLElist(new int[]{1,2,3,4}));
    }
}
