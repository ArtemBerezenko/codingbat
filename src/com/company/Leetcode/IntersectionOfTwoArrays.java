package com.company.Leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        set1.retainAll(set2);

        int[] result = new int[set1.size()];

        int i = 0;
        for (Integer item : set1) {
            result[i++] = item;
        }

        return result;
    }

    public static void main(String[] args) {
        display(intersection(new int[] {2,2}, new int[] {1,2,2,1}));
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }

}
