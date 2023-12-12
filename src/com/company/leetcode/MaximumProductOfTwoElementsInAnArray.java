package com.company.leetcode;

import java.util.Arrays;
import java.util.List;

public class MaximumProductOfTwoElementsInAnArray {

    public static int maxProduct(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().sorted().toList();
        
        return (list.get(list.size() - 1) - 1) * (list.get(list.size() - 2) - 1);
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1,5,4,5}));
    }
}
