package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i + 1 < arr.length; i++) {
            min = Math.min(min, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i + 1 < arr.length; i++) {
            if (arr[i + 1] - arr[i] == min) {
                ans.add(List.of(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{4,2,1,3}));
    }
}
