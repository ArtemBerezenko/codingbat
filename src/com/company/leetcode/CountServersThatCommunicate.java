package com.company.leetcode;


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class CountServersThatCommunicate {
    public static int countServers(int[][] grid) {
        Set<Pair> set = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    set.add(new Pair(i, j));
                }
            }
        }
        Set<Pair> communicating = new HashSet<>();

        set.stream()
                .collect(Collectors.groupingBy(Pair::column))
                .values().stream()
                .filter(entry -> entry.size() > 1)
                .forEach(communicating::addAll);

        set.stream()
                .collect(Collectors.groupingBy(Pair::row))
                .values().stream()
                .filter(entry -> entry.size() > 1)
                .forEach(communicating::addAll);

        return communicating.size();
    }

    record Pair(Integer column, Integer row) {
    }

    static void main() {
        System.out.println(countServers(new int[][]{{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}}));
    }
}
