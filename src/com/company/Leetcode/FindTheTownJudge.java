package com.company.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheTownJudge {
    public static int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1;
        Set<Integer> people = new HashSet<>();
        Map<Integer, Integer> applicants = new HashMap<>();

        for (int[] arr : trust) {
            people.add(arr[0]);
            applicants.computeIfPresent(arr[1], (k, v) -> v + 1);
            applicants.putIfAbsent(arr[1], 1);
        }

        for (Map.Entry<Integer, Integer> item : applicants.entrySet()) {
            int applicant = item.getKey();
            int count = item.getValue();
            if (!people.contains(applicant) && count == n - 1) {
                return applicant;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(3, new int[][]{{1, 2}, {2, 3}}));
    }
}

//4
//        {{1,3],{1,4],[2,3],[2,4],[4,3]]
//
//[[1,2],[2,3]]