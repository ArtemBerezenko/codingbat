package com.company.Leetcode;

import java.util.*;

public class FindAllNumbersDisappearedInAnArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                set.add(i);
            } else set.remove(i);
        }

        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        display(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    private static void display(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println(" ");
    }
}
