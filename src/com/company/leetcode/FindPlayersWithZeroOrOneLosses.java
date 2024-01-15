package com.company.leetcode;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int[] array : matches) {
            map.putIfAbsent(array[0], 0);
            map.computeIfPresent(array[1], (k, v) -> v + 1);
            map.putIfAbsent(array[1], 1);
        }

        List<Integer> noLose = new ArrayList<>();
        List<Integer> oneLose = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                noLose.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                oneLose.add(entry.getKey());
            }
        }

        Collections.sort(noLose);
        Collections.sort(oneLose);
        return List.of(noLose, oneLose);
    }

    public static void main(String[] args) {
        System.out.println(findWinners( new int[][] {{2,3},{1,3},{5,4},{6,4}}));
    }
}
