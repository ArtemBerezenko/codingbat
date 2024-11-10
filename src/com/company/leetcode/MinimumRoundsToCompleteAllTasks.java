package com.company.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public static int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() == 1) {
                return -1;
            }

            if (entry.getValue() % 3 == 0) {
                count += entry.getValue() / 3;
            } else {
                count += entry.getValue() / 3 + 1;
            }

        }

        return count;
        }

        public static void main (String[] args) {
            System.out.println(minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
        }
    }
