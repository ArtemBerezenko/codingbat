package com.company.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0;
        int r = arr.length - k;
        List<Integer> result = new ArrayList<>();

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (x - arr[mid] <= arr[mid + k] - x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        for (int i = l; i < l + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5}, 4, 3));
    }
}
