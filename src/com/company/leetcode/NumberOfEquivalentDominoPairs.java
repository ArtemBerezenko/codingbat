package com.company.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfEquivalentDominoPairs {

    public static int numEquivDominoPairs(int[][] dominoes) {
        Map<Set<Integer>, Integer> map = new HashMap<>();
        int count = 0;

        for (int[] item : dominoes) {
            Set<Integer> pair = new HashSet<>(Arrays.asList(item[0], item[1]));

            count += map.getOrDefault(pair, 0);

            map.computeIfPresent(pair, (k, v) -> v + 1);
            map.putIfAbsent(pair, 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][] {{1,2},{2,1},{3,4},{5,6}}));
    }
}
