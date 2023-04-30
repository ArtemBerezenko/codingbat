package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> currentList = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            Integer curr = nums[i];

            if (!currentList.isEmpty()) {
                Integer prev = currentList.getLast();
                if (curr - prev != 1) {
                    result.add(currentList);
                    currentList = new LinkedList<>();
                }
            }
            currentList.add(curr);
        }

        if (!currentList.isEmpty()) {
            result.add(currentList);
        }

        return result.stream()
                .map(SummaryRanges::getResult)
                .toList();
    }

    private static String getResult(List<Integer> list) {
        LinkedList<Integer> linkedList = new LinkedList<>(list);
        if (list.size() > 1) {
            return linkedList.getFirst() + "->" +linkedList.getLast();
        }
        return linkedList.getFirst().toString();
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }

}
