package com.company.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MinimumPairRemovalToSortArrayI {
    public static int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());

        while (!isSorted(list)) {
            modifyList(list);
        }

        return nums.length - list.size();
    }

    private static boolean isSorted(List<Integer> list) {
        return IntStream.range(1, list.size()).allMatch(i -> list.get(i - 1).compareTo(list.get(i)) <= 0);
    }

    private static List<Integer> modifyList(List<Integer> list) {

        int minSum = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < list.size(); i++) {
            int sum = list.get(i - 1) + list.get(i);

            if (minSum > sum) {
                minSum = sum;
                index = i - 1;
            }
        }

        list.remove(index);
        list.set(index, minSum);

        return list;
    }

    public static void main(String[] args) {
        System.out.println(minimumPairRemoval(new int[]{5,2,3,1}));
    }
}
