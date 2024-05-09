package com.company.leetcode;

import java.util.*;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        int[] sorted = Arrays.stream(score).boxed().sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }

        String[] ranks = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (map.get(score[i]) == 0) {
                ranks[i] = "Gold Medal";
            } else if (map.get(score[i]) == 1) {
                ranks[i] = "Silver Medal";
            } else if (map.get(score[i]) == 2) {
                ranks[i] = "Bronze Medal";
            } else {
                ranks[i] = String.valueOf(map.get(score[i]) + 1);
            }
        }

        return ranks;
    }

    public static String[] findRelativeRanks1(int[] score) {
        int[] scoreCopy = new int[score.length];
        System.arraycopy(score, 0, scoreCopy, 0, score.length);

        Map<Integer, Integer> scoreToIndex = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            scoreToIndex.put(scoreCopy[i], i);
        }

        Arrays.sort(scoreCopy);

        String[] rank = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                rank[scoreToIndex.get(scoreCopy[score.length - i - 1])] = "Gold Medal";
            } else if (i == 1) {
                rank[scoreToIndex.get(scoreCopy[score.length - i - 1])] = "Silver Medal";
            } else if (i == 2) {
                rank[scoreToIndex.get(scoreCopy[score.length - i - 1])] = "Bronze Medal";
            } else {
                rank[scoreToIndex.get(scoreCopy[score.length - i - 1])] = Integer.toString(i + 1);
            }
        }
        return rank;
    }

    public static void main(String[] args) {
        System.out.println(findRelativeRanks(new int[]{10,3,8,9,4}));
    }
}
