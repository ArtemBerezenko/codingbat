package com.company.Leetcode;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int i = 0;
        for (int s : set) {
            nums[i++] = s;
        }

        return set.size();
    }

    public int removeDuplicatesRIGHT(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int result = removeDuplicates(IntStream.of(-3,-1,0,0,0,3,3).toArray());
        System.out.println(result);
    }
}
