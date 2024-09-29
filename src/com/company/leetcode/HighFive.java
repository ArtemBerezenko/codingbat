package com.company.leetcode;

import java.util.*;

public class HighFive {

    public static int[][] highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            map.computeIfAbsent(item[0], k -> new ArrayList<>()).add(item[1]);
        }

        return map.entrySet().stream()
                .map(e -> {
                    e.getValue().sort(Comparator.reverseOrder());
                    int sum = e.getValue().stream()
                            .limit(5)
                            .mapToInt(Integer::intValue)
                            .sum();
                    return new int[] {e.getKey(), sum/5};
                })
                .toArray(int[][]::new);
    }

    public static int[][] highFive2(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

        for (int[] item : items) {
            PriorityQueue<Integer> pq = map.computeIfAbsent(item[0], k -> new PriorityQueue<>());
            pq.offer(item[1]);

            if (pq.size() > 5) {
                pq.poll();
            }
        }

       return map.entrySet().stream()
                .map(e -> {
                    int sum = e.getValue().stream()
                            .mapToInt(Integer::intValue)
                            .sum();
                    return new int[] {e.getKey(), sum/5};
                })
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(highFive(new int[][]{{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}}));
    }
}
