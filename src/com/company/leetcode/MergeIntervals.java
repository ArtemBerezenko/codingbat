package com.company.leetcode;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<List<Integer>> resultList = new LinkedList<>();
        resultList.add(new ArrayList<>(Arrays.stream(intervals[0]).boxed().toList()));

        for (int i = 1; i < intervals.length; i++) {
            List<Integer> prev = resultList.getLast();

            if (prev.get(1) < intervals[i][0]) {
                resultList.add(new ArrayList<>(List.of(intervals[i][0], intervals[i][1])));
            } else {
                resultList.getLast().set(1, Math.max(prev.get(1), intervals[i][1]));
            }
        }

        return resultList.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
//        System.out.println(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}));
        System.out.println(merge(new int[][]{{1,4},{2,3}}));

    }
}
