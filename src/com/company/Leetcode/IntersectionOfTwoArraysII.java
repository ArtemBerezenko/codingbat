package com.company.Leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();

        list1.retainAll(list2);
        list2.retainAll(list1);

        for (Integer item : list1) {
            if (list2.contains(item)) {
                resultList.add(item);
                list2.remove(item);
            }
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        display(intersect(new int[] {1,2,2,2,1,5}, new int[] {2,2,5,5}));
//        display(intersect(new int[] {1,2,2,1}, new int[] {2,2}));
//        display(intersect(new int[] {1,2,2,1}, new int[] {2}));
        display(intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4}));
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
    }
}
