package com.company.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudgeII {
    public static int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }
        
        Set<Integer> ordinaries = new HashSet<>();
        Map<Integer, Integer> trusted = new HashMap<>();
        
        for (int[] arr: trust) {
            ordinaries.add(arr[0]);
            trusted.computeIfPresent(arr[1], (k, v) -> v + 1);
            trusted.putIfAbsent(arr[1], 1);
        }
        
        return trusted.entrySet().stream()
                .filter(e -> e.getValue() == n - 1 && !ordinaries.contains(e.getKey()))
                .findAny()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][] {{1,2},{2,3}}));
    }
}
