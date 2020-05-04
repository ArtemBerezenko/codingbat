package com.company.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length > 0) {
            return getMedian(nums2);
        }
        if (nums2.length == 0 && nums1.length > 0) {
            return getMedian(nums1);
        }
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.stream(nums1).boxed().collect(Collectors.toList()));
        list.addAll(Arrays.stream(nums2).boxed().collect(Collectors.toList()));
        list = list.stream().sorted().collect(Collectors.toList());
        if (list.size() % 2 == 0) {
            int i = list.size() / 2;
            return (double) (list.get(i - 1) + list.get(i)) / 2;
        } else {
            return list.get(list.size() / 2);
        }
    }

    private static double getMedian(int[] items) {
        if (items.length == 1) return items[0];
        if (items.length % 2 == 0) {
            int i = items.length / 2;
            return (double) (items[i - 1] + items[i]) / 2;
        } else {
            return items[items.length / 2];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-1, 3};
        double result = findMedianSortedArrays(nums1, nums2);
    }
}
